package applicationUI;

public class Counter extends java.util.Observable {
	private int count;
	
	private String hint;
	
	private int max;
	
	private int last;
	
	public Counter() {
		this.count = 0;
	}
	
	public void count() {
		count ++;
		setChanged();
		notifyObservers();
	}
	
	public void setHint(String hint){
		this.hint = hint;
		setChanged();
		notifyObservers();
	}
	
	public void setMax(String max){
		this.max = Integer.parseInt(max);
		setChanged();
		notifyObservers();
	}
	
	public void setLast(int last){
		this.last = last;
		setChanged();
		notifyObservers();
	}
	
	public int getLast(){
		return this.last;
	}
	public int getCount() {
		return count;
	}

	public String getHint(){
		return hint;
	}

	public int getMax(){
		return max;
	}

}
