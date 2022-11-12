package a2223.hw2;

public class ConnectFour55742115 implements ConnectFour{

	boolean iswin=false;
	Player winner =null;
	Player turn = Player.X;
	Player prevTurn = null;
	int count=0;
	
	char [][]grid = new char[7][7];
	@Override
	public void init() {
		// TODO Auto-generated method stub
		for(int i =0;i<6;i++) {
			for(int j =0;j<7;j++) {
				grid[i][j]='_';
			}
		}
		for(int j =0;j<7;j++) {
			grid[6][j]=(char)(j+'0');
		}
		count=0;
		turn = Player.X;
		iswin = false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return count<=41 && !iswin;
	}

	@Override
	public Player getTurn() {
		// TODO Auto-generated method stub
		return turn;
	}

	@Override
	public void drop(int col) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		if(col <0||col>6)
			throw new IllegalArgumentException();
		int i =5;
		char currPlayer = this.getTurn().toString().charAt(0);
		while(i>=0) {
			if(grid[i][col]=='_') {
				grid[i][col]=currPlayer;
				if(this.getTurn()==(Player.X)) {
					prevTurn=turn;
					turn=Player.O;
				}
				else {
					prevTurn=turn;
					turn = Player.X;
				}
				count++;
				break;
			}
				i--;
		}
		if(i<0) 
			throw new IllegalStateException();
		
		
		
		//check vertical
		for(int x=0;x<=2;x++) {
			for(int y=0;y<=6;y++) {
				//System.out.println("Current checking x:"+x+"y:"+y);
				if(grid[x][y]==currPlayer&&grid[x+1][y]==currPlayer&&grid[x+2][y]==currPlayer&&grid[x+3][y]==currPlayer)
				{
					System.out.println("win");
					winner=prevTurn;
					iswin=true;
				}
			}
		}
		
		//check horizontal
		for(int x=0;x<=6;x++) {
			for(int y=0;y<=3;y++) {
				//System.out.println("Current checking x:"+x+"y:"+y);
				if(grid[x][y]==currPlayer&&grid[x][y+1]==currPlayer&&grid[x][y+2]==currPlayer&&grid[x][y+3]==currPlayer)
				{
					System.out.println("win");
					winner=prevTurn;
					iswin=true;
				}
			}
		}
		//check forward slash
		for(int x=0;x<=2;x++) {
			for(int y=0;y<=3;y++) {
				if(grid[x][y]==currPlayer&&grid[x+1][y+1]==currPlayer&&grid[x+2][y+2]==currPlayer&&grid[x+3][y+3]==currPlayer)
				{
					System.out.println("win");
					winner=prevTurn;
					iswin=true;
				}
			}
		}
		//check backward slash
		for(int x=5;x>=3;x--) {
			for(int y=0;y<=3;y++) {
				if(grid[x][y]==currPlayer&&grid[x-1][y+1]==currPlayer&&grid[x-2][y+2]==currPlayer&&grid[x-3][y+3]==currPlayer)
				{
					System.out.println("win");
					winner=prevTurn;
					iswin=true;
				}
			}
		}
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++) {
				System.out.print("|"+grid[i][j]);
			}
			System.out.println("|");
		}
	}

	@Override
	public boolean hasWinner() {
		// TODO Auto-generated method stub
		return iswin;
	}

	@Override
	public Player getWinner() throws IllegalStateException {
		// TODO Auto-generated method stub
		if(winner==null||hasNext())
			throw new IllegalStateException();
		return winner;
	}

}
