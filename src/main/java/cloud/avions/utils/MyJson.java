package cloud.avions.utils;

public class MyJson {

    private Object data;
    private MyError myError;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MyError getError() {
        return myError;
    }

    public void setError(MyError myError) {
        this.myError = myError;
    }
}
