package suanfa.kelusikaer;

public class EData {
char start;
char end;
int weight;
public EData(char start, char end, int weight) {
	super();
	this.start = start;
	this.end = end;
	this.weight = weight;
}
@Override
public String toString() {
	return "EData [<" + start + ", " + end + "> =" + weight + "]";
}

}
