package bradley.OnlineDiaryProject.faces.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bradley
 */
public class JsfUtil {
    
    /**
     *
     * @param entities
     * @param selectOne
     * @return
     */
    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }
    
    /**
     *
     * @param ex
     * @param defaultMsg
     */
    public static void ensureAddErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }
    
    /**
     *
     * @param messages
     */
    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    /**
     *
     * @param msg
     */
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     *
     * @param msg
     */
    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    /**
     *
     * @param key
     * @return
     */
    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }
    
    /**
     *
     * @param requestParameterName
     * @param converter
     * @param component
     * @return
     */
    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }
    
    /**
     *
     * @param <T>
     * @param arr
     * @return
     */
    public static <T> List<T> arrayToList(T[] arr) {
        if (arr == null) {
            return new ArrayList<T>();
        }
        return Arrays.asList(arr);
    }

    /**
     *
     * @param <T>
     * @param arr
     * @return
     */
    public static <T> Set<T> arrayToSet(T[] arr) {
        if (arr == null) {
            return new HashSet<T>();
        }
        return new HashSet(Arrays.asList(arr));
    }
    
    /**
     *
     * @param c
     * @return
     */
    public static Object[] collectionToArray(Collection<?> c) {
        if (c == null) {
            return new Object[0];
        }
        return c.toArray();
    }

    /**
     *
     * @param <T>
     * @param set
     * @return
     */
    public static <T> List<T> setToList(Set<T> set) {
        return new ArrayList<T>(set);
    }
    
    /**
     *
     * @param object
     * @param converter
     * @return
     */
    public static String getAsConvertedString(Object object, Converter converter) {
        return converter.getAsString(FacesContext.getCurrentInstance(), null, object);
    }
    
    /**
     *
     * @param collection
     * @return
     */
    public static String getCollectionAsString(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return "(No Items)";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (Object item : collection) {
            if (i > 0) {
                sb.append("<br />");
            }
            sb.append(item);
            i++;
        }
        return sb.toString();
    }
}
