package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class webutils {
    public static  <T> T copyparamtobean(Map value, T bean)
    {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
