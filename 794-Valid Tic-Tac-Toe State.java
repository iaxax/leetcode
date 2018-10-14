class Solution {
    public boolean validTicTacToe(String[] board) {
        int Xnum = 0, Onum = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                switch (c) {
                    case 'X': Xnum += 1; break;
                    case 'O': Onum += 1; break;
                }
            }
        }
        if (!(Xnum == Onum || Xnum == Onum + 1)) {
            return false;
        }
        
        int Xwin = 0, Owin = 0;
        for (int i = 0; i < 3; ++i) {
            String row = board[i];
            if (row.charAt(0) == row.charAt(1) && row.charAt(1) == row.charAt(2)) {
                switch (row.charAt(0)) {
                    case 'X': Xwin += 1; break;
                    case 'O': Owin += 1; break;
                }
            }
            
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                switch(board[0].charAt(i)) {
                    case 'X': Xwin += 1; break;
                    case 'O': Owin += 1; break;
                }
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            switch (board[0].charAt(0)) {
                case 'X': Xwin += 1; break;
                case 'O': Owin += 1; break;
            }
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            switch (board[0].charAt(2)) {
                case 'X': Xwin += 1; break;
                case 'O': Owin += 1; break;
            }
        }
        
        if ((Xwin > 0 && Xnum == Onum) || (Owin > 0 && Xnum > Onum)) {
            return false;
        }
        
        return true;
    }
}