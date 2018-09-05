class Solution {
    
    private double r, x, y;

    public Solution(double radius, double x_center, double y_center) {
        r = radius; x = x_center; y = y_center;
    }
    
    public double[] randPoint() {
        double newR = Math.sqrt(Math.random()) * r;
        double angle = Math.random() * 2 * Math.PI;
        double newX = newR * Math.cos(angle) + x;
        double newY = newR * Math.sin(angle) + y;
        return new double[] {newX, newY};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */