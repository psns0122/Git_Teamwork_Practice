public abstract class StudentDBIO {
    private static final StudentDBIO INSTANCE=null;

    protected StudentDBIO(){};
    public static StudentDBIO getInstance(){
        return INSTANCE; }
}
