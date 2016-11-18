package week7;

import java.io.IOException;
import java.io.Reader;

public class ShlokavicaReader extends Reader {
	private Reader in;

	public ShlokavicaReader(Reader in) {
		this.in = in;
	}

	@Override
	public int read() throws IOException {
		int c = in.read();
		return convertToBulgarianPhonetic(c);
	}

	private int convertToBulgarianPhonetic(int c) {
		char crrChar = (char) c;
		int result;
		switch (crrChar) {
		case 'a':
			result = (int) 'а';
			break;
		case 'b':
			result = (int) 'б';
			break;
		case 'w':
			result = (int) 'в';
			break;
		case 'g':
			result = (int) 'г';
			break;
		case 'd':
			result = (int) 'д';
			break;
		case 'e':
			result = (int) 'е';
			break;
		case 'v':
			result = (int) 'ж';
			break;
		case 'z':
			result = (int) 'з';
			break;
		case 'i':
			result = (int) 'и';
			break;
		case 'j':
			result = (int) 'й';
			break;
		case 'k':
			result = (int) 'к';
			break;
		case 'l':
			result = (int) 'л';
			break;
		case 'm':
			result = (int) 'м';
			break;
		case 'n':
			result = (int) 'н';
			break;
		case 'o':
			result = (int) 'о';
			break;
		case 'p':
			result = (int) 'п';
			break;
		case 'r':
			result = (int) 'р';
			break;
		case 's':
			result = (int) 'с';
			break;
		case 't':
			result = (int) 'т';
			break;
		case 'u':
			result = (int) 'у';
			break;
		case 'f':
			result = (int) 'ф';
			break;
		case 'h':
			result = (int) 'х';
			break;
		case 'c':
			result = (int) 'ц';
			break;
		case '`':
			result = (int) 'ч';
			break;
		case '[':
			result = (int) 'ш';
			break;
		case ']':
			result = (int) 'щ';
			break;
		case 'y':
			result = (int) 'ъ';
			break;
		case 'x':
			result = (int) 'ь';
			break;
		case '\\':
			result = (int) 'ю';
			break;
		case 'q':
			result = (int) 'я';
			break;
		default:
			result = (int) crrChar;

		}
		return result;
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return in.read(cbuf, off, len);
	}

}
