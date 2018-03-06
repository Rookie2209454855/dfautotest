package almTest.infrastructure;

public class Constants {
    private Constants() {}
    public static final String HOST = "192.168.57.26";
    public static final String PORT = "5174";

    public static final String USERNAME = "fengtiepeng";
    public static final String PASSWORD = "a123456";

    public static final String DOMAIN = "测试部";
    public static final String PROJECT = "测试项目";


    /**
     * Supports running tests correctly on both versioned
     * and non-versioned projects.
     * @return true if entities of entityType support versioning
     */
    public static boolean isVersioned(String entityType,
                                      final String domain, final String project)
            throws Exception {

        RestConnector con = RestConnector.getInstance();
        String descriptorUrl =
                con.buildUrl("api/domains/"
                        + domain
                        + "/projects/"
                        + project
                        + "/customization/entities/"
                        + entityType);

        String descriptorXml =
                con.httpGet(descriptorUrl, null, null).toString();
        EntityDescriptor descriptor =
                EntityMarshallingUtils.marshal
                        (EntityDescriptor.class, descriptorXml);

        boolean isVersioned = descriptor.getSupportsVC().getValue();

        return isVersioned;
    }

    public static String generateFieldXml(String field, String value) {
        return "<Field Name=\"" + field
                + "\"><Value>" + value
                + "</Value></Field>";
    }

    /**
     * This string used to create new "requirement" type entities.
     * "data": [
         {
         "type": "defect",
         "name": "Willoughby dissaffected with Marianne",
         "description": "Refuses to acknowledge her.",
         "priority": "4-Very High",
         "detected-by": "steves",
         "severity": "2-Medium",
         "creation-time": "2014-11-30"
         }
         ]
     */
    public static final String entityToPostName = "req"
            + Double.toHexString(Math.random());
    public static final String entityToPostFieldName =
            "type-id";
    public static final String entityToPostFieldValue = "1";

    public static final String entityToPostFormat =
            "<Entity Type=\"defect\">"
                    + "<Fields>"
                    + Constants.generateFieldXml("detected-by", "fengtiepeng")
                    + Constants.generateFieldXml("creation-time", "2010-03-02")
                    + Constants.generateFieldXml("severity", "2-Medium")
                    + Constants.generateFieldXml("name", "测试数据")
                    + "</Fields>"
                    + "</Entity>";

    public static final String entityToPostXml =
            String.format(entityToPostFormat, "name", entityToPostName, entityToPostFieldName,entityToPostFieldValue);

    public static final CharSequence entityToPostFieldXml =
            generateFieldXml(Constants.entityToPostFieldName,
                    Constants.entityToPostFieldValue);

}
