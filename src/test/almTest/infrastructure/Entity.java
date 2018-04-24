package almTest.infrastructure;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "fields" })
@XmlRootElement(name = "Entity")
public class Entity {

    @XmlElement(name = "Fields", required = true)
    protected Entity.Fields fields;
    @XmlAttribute(name = "Type", required = true)
    protected String type;


    public Entity(Entity entity) {
        type = entity.getType();
        fields = new Entity.Fields(entity.getFields());
    }

    public Entity() {}

    /**
     * Gets the value of the fields property.
     *
     * @return possible object is {@link Entity.Fields }
     *
     */
    public Entity.Fields getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     *
     * @param value
     *            allowed object is {@link Entity.Fields }
     *
     */
    public void setFields(Entity.Fields value) {
        this.fields = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Java class for anonymous complex type.
     *
     * The following schema fragment specifies the expected content contained within this class.
     *
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Field" maxOccurs="unbounded">
     *           <complexType>
     *             <complexContent>
     *               <restriction base=
     *                  "{http://www.w3.org/2001/XMLSchema}anyType">
     *                 <sequence>
     *                   <element name="Value"
     *                     type="{http://www.w3.org/2001/XMLSchema}string"
     *                       maxOccurs="unbounded"/>
     *                 </sequence>
     *                 <attribute name="Name" use="required"
     *                   type="{http://www.w3.org/2001/XMLSchema}string" />
     *               </restriction>
     *             </complexContent>
     *           </complexType>
     *         </element>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "field" })
    public static class Fields {

        @XmlElement(name = "Field", required = true)
        protected List<Field> field;


        public Fields(Fields fields) {
            field = new ArrayList<Field>(fields.getField());
        }


        public Fields() {}

        /**
         * Gets the value of the field property.
         *

         * This accessor method returns a reference to the live list, not a snapshot.
         * Therefore any  modification you make to the returned list will be present
         * inside the JAXB object.
         * This is why there is no set method for the field property.
         *
         * For example, to add a new item, do as follows:
         *
         *  getField().add(newItem);
         *
         * Objects of the following type(s) are allowed in the list {@link Entity.Fields.Field }
         *
         *
         */
        public List<Field> getField() {
            if (field == null) {
                field = new ArrayList<Field>();
            }
            return this.field;
        }

        /**
         * Java class for anonymous complex type.
         *
         * The following schema fragment specifies the expected content contained
         * within this class.
         *
         * <complexType>
         *   <complexContent>
         *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       <sequence>
         *         <element name="Value"
         *            type="{http://www.w3.org/2001/XMLSchema}string"
         *            maxOccurs="unbounded"/>
         *       </sequence>
         *       <attribute name="Name" use="required"
         *          type="{http://www.w3.org/2001/XMLSchema}string" />
         *     </restriction>
         *   </complexContent>
         * </complexType>
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "value" })
        public static class Field {

            @XmlElement(name = "Value", required = true)
            protected List<String> value;
            @XmlAttribute(name = "Name", required = true)
            protected String name;

            /**
             * Gets the value of the value property.
             *
             * This accessor method returns a reference to the live list, not a snapshot.
             * Therefore, any modification you make to the returned list will be present
             * inside the JAXB object. This is why there is no set method
             * for the value property.
             *
             * For example, to add a new item, do as follows:
             *
             * getValue().add(newItem);
             *

             * Objects of the following type(s) are allowed in the list {@link String }
             *
             *
             */
            public List<String> getValue() {
                if (value == null) {
                    value = new ArrayList<String>();
                }
                return this.value;
            }

            /**
             * Gets the value of the name property.
             *
             * @return possible object is {@link String }
             *
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             *
             * @param value
             *            allowed object is {@link String }
             *
             */
            public void setName(String value) {
                this.name = value;
            }

        }

    }


}
