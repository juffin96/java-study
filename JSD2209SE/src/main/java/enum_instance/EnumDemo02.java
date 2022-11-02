package enum_instance;

/**
 * 枚举类用于左信息标志和信息分类，优雅！
 * 常量做信息标志和分类：入参不受控制，入参太随性无法严谨。
 */
public class EnumDemo02 {
    public static void main(String[] args) {
        move(Oritation.UP);
    }

    public static void move(Oritation oritation) {
        switch (oritation) {
            case UP:
                System.out.println("控制往上移动");
                break;
            case DOWN:
                System.out.println("控制往下移动");
                break;
            case LEFT:
                System.out.println("控制往左移动");
                break;
            case RIGHT:
                System.out.println("控制往右移动");
                break;
            default:
                break;
        }
    }
}
