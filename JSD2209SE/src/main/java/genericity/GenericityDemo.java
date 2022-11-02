package genericity;

/**
 * 泛型类：使用了泛型定义的类就是泛型类
 * 泛型方法：
 * 泛型变量建议使用E, T, K, V
 */
public class GenericityDemo {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Java");
        list.add("MySQL");
        list.remove("Java");

        Data<Student> data = new StudentData();
        data.add(new Student());
        data.delete(new Student());
    }

    public static <T> String arrToString(T[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                T ele = nums[i];
                sb.append(i == nums.length - 1 ? ele : ele + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
