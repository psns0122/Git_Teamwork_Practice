package day05.Builder;

public class HamburgerSet extends Hamburger {
    private String beverage;
    private boolean sideDish;

    private HamburgerSet(BurgerSetBuilder builder) {
        super(builder);
        this.beverage = builder.beverage;
        this.sideDish = builder.sideDish;

    }

    public static class BurgerSetBuilder extends BurgerBuilder {
        private String beverage;
        private boolean sideDish = false;

        public BurgerSetBuilder(String bun, String patty, String beverage) {
            super(bun, patty);
            this.beverage = beverage;
        }

        public BurgerBuilder addSideDish() {
            this.sideDish =true;
            return this;
        }
        //핵심 최종적으로 BurgerBuilder 객체를 반환하는 메서드를 생성
        public HamburgerSet build(){
            return new HamburgerSet(this);
        }
    }
    @Override
    public String toString() {
        return super.toString() + " Set{beverage=" + beverage + ", sideDish=" + sideDish + '}';
    }
}
