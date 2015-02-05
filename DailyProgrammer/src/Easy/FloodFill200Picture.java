package Easy;

public class FloodFill200Picture {
	int h, w;
	char[][] picture;
	
	public FloodFill200Picture(int w, int h) {
		this.w = w;
		this.h = h;
		picture = new char[h][w];
		for (int i = 0; i < h; i++)
			for (int j  = 0; j < w; j++)
				picture[i][j] = '.';
	}
	
	public void printPicture() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(picture[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public boolean bucketFill(int x, int y, char c) {
		if (x < w && x > 0 && y < h && y > 0) {
			
			return true;
		} else {
			return false;
		}
	}
}
