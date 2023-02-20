package eqaulshashcode;

public class MyClass {
    private final String importantField;
    private final String anotherField;

    public MyClass(final String equalField, final String anotherField) {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }

//    @Override
//    public boolean equals(final Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final MyClass other = (MyClass) obj;
//        if (importantField == null) {
//            return other.importantField == null;
//        } else return importantField.equals(other.importantField);
//    }
}
