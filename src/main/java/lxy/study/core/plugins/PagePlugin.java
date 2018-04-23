package lxy.study.core.plugins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import lxy.study.utils.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Project: mybatis.study 分页插件
 *
 * @author Luo.xiaoyi
 * @date 2018/04/21
 *
 * 定义需要被拦截的对象，方法，以及方法的相关参数
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,
    Integer.class}))
public class PagePlugin implements Interceptor {

  /**
   * 数据库类型
   */
  private static String dialect;
  /**
   * 针对哪些sql进行分页
   */
  private static String pageSqlId;

  private Logger logger = LogManager.getLogger(this.getClass());

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    // 获取 StatementHandler 对象
    StatementHandler statementHandler = null;
    if (invocation.getTarget() instanceof StatementHandler) {
      statementHandler = StatementHandler.class.cast(invocation.getTarget());
    }

    // 获取元数据对象
    MetaObject metaObject = MetaObject
        .forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
            SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());

    // 获取 MappedStatement
    MappedStatement mappedStatement = (MappedStatement) metaObject
        .getValue("delegate.mappedStatement");

    // 拿到sql的唯一标识
    String sqlId = mappedStatement.getId();

    // 匹配上了，才进行分页
    if (sqlId.matches(pageSqlId)) {
      // 获取原始的sql语句
      BoundSql boundSql = statementHandler.getBoundSql();
      String sql = boundSql.getSql();

      // 获取分页参数map.put("",PageInfo)
      Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
      if (params != null) {
        PageInfo pageInfo = (PageInfo) params.get("pageInfo");

        // 查询总数的sql
        String countSql = "select count(*) from (" + sql + ") a";
        logger.debug(this.getClass() + " countSql: " + countSql);

        // 查询总数执行
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement ps = connection.prepareStatement(countSql);

        ParameterHandler ph = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
        ph.setParameters(ps);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
          int totalCount = rs.getInt(1);
          pageInfo.setTotalNumber(totalCount);
          if (totalCount % pageInfo.getPageSize() == 0) {
            pageInfo.setTotalPage(totalCount / pageInfo.getPageSize());
          } else {
            pageInfo.setTotalPage(totalCount / pageInfo.getPageSize() + 1);
          }
        }

        // 拼接selectPage
        String pageSql = buildPageSql(sql, pageInfo);
        logger.debug(this.getClass() + " pageSql: " + pageSql);

        // 替换原来的sql
        metaObject.setValue("delegate.boundSql.sql", pageSql);

      }
    }

    // 继续执行下面的程序
    return invocation.proceed();
  }

  private String buildPageSql(String sql, PageInfo pageInfo) {
    if ("mysql".equals(dialect)) {
      return sql + " LIMIT " + pageInfo.getCurrentPageIndex() * pageInfo.getPageSize() + ", "
          + pageInfo.getPageSize();
    }

    return "";
  }

  /**
   * 对目标对象使用Plugin.wrap生成target的动态代理对象，该代理对象，会在执行该target对象的相关接口方法 之前执行拦截器的intercept方法，具体可以参考Plugin.invoke方法
   * 相关接口方法的定义为： 由这个@Intercepts注解定义相关对象的所有方法
   */
  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    dialect = properties.getProperty("dialect");
    if(!StringUtils.hasContent(dialect)){
      dialect = "mysql";
    }
    pageSqlId = properties.getProperty("pageSqlId");
    if(!StringUtils.hasContent(pageSqlId)){
      pageSqlId = ".*ByPage";
    }
  }
}
