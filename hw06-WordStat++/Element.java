public class Element implements Comparable<Element> {
	private IntList array;
	private int totalCount, lastLineId, firstInFile;

	public Element(int id, int lineId) {
		array = new IntList();
		array.push_back(id);
		totalCount = 1;
		lastLineId = lineId;
		firstInFile = lineId;
	}

	public Element update(int id, int lineId) {
		totalCount++;
		if (lineId != lastLineId) {
			lastLineId = lineId;
			array.push_back(id);
		}
		return this;
	}

	public int compareTo(Element other) {
		if (totalCount != other.totalCount) {
			return Integer.compare(totalCount, other.totalCount);
		}
		if (firstInFile != other.firstInFile) {
			return Integer.compare(firstInFile, other.firstInFile);
		}
		return Integer.compare(array.get(0), other.array.get(0));
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(String.format("%d ", totalCount));
		for (int i = 0; i < array.size(); i++) {
			str.append(String.format("%d", array.get(i)));
			if (i != array.size() - 1) {
				str.append(' ');
			}
		}
		return str.toString();
	}
}