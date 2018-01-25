class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";
    }
    
    private boolean isIPv4(String ip) {
        if (ip.length() > 0 && ip.charAt(ip.length() - 1) == '.') return false;
        
        String[] strs = ip.split("\\.");
        if (strs.length != 4) return false;
        
        for (int i = 0; i < 4; ++i) {
            if (strs[i].length() > 4) return false;
            int num = 0;
            for (char c : strs[i].toCharArray()) {
                if (c < '0' || c > '9') return false;
                num = num * 10 + c - '0';
            }
            if (strs[i].length() == 0 || strs[i].charAt(0) == '0' && strs[i].length() > 1 || num > 255) return false;
        }
        
        return true;
    }
    
    private boolean isIPv6(String ip) {
        if (ip.length() > 0 && ip.charAt(ip.length() - 1) == ':') return false;

        String[] strs = ip.split(":");
        if (strs.length != 8) return false;
        
        for (int i = 0; i < 8; ++i) {
            int len = strs[i].length();
            if (len == 0 || len > 4) return false;
            for (int j = 0; j < len; ++j) {
                char c = strs[i].charAt(j);
                if (!(c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F' || c >= '0' && c <= '9')) return false;
            }
        }
        return true;
    }
}
