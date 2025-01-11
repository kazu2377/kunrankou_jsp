package example;

import java.io.Serializable;

public class SampleBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    // 引数のないコンストラクタ
    public SampleBean() {}

    // nameプロパティのgetter
    public String getName() {
        return name;
    }

    // nameプロパティのsetter
    public void setName(String name) {
        this.name = name;
    }
}
