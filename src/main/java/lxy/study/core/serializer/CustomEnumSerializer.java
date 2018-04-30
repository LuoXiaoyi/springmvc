package lxy.study.core.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.io.IOException;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/26
 */
public class CustomEnumSerializer extends StdScalarSerializer<Enum<?>>{

  protected CustomEnumSerializer(Class<Enum<?>> t) {
    super(t);
  }

  @Override
  public void serialize(Enum<?> value, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    if(value != null ){
      gen.writeString(value.toString());
    }
  }
}
