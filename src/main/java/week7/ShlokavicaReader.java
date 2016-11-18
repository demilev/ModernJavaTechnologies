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
			result = (int) '�';
			break;
		case 'b':
			result = (int) '�';
			break;
		case 'w':
			result = (int) '�';
			break;
		case 'g':
			result = (int) '�';
			break;
		case 'd':
			result = (int) '�';
			break;
		case 'e':
			result = (int) '�';
			break;
		case 'v':
			result = (int) '�';
			break;
		case 'z':
			result = (int) '�';
			break;
		case 'i':
			result = (int) '�';
			break;
		case 'j':
			result = (int) '�';
			break;
		case 'k':
			result = (int) '�';
			break;
		case 'l':
			result = (int) '�';
			break;
		case 'm':
			result = (int) '�';
			break;
		case 'n':
			result = (int) '�';
			break;
		case 'o':
			result = (int) '�';
			break;
		case 'p':
			result = (int) '�';
			break;
		case 'r':
			result = (int) '�';
			break;
		case 's':
			result = (int) '�';
			break;
		case 't':
			result = (int) '�';
			break;
		case 'u':
			result = (int) '�';
			break;
		case 'f':
			result = (int) '�';
			break;
		case 'h':
			result = (int) '�';
			break;
		case 'c':
			result = (int) '�';
			break;
		case '`':
			result = (int) '�';
			break;
		case '[':
			result = (int) '�';
			break;
		case ']':
			result = (int) '�';
			break;
		case 'y':
			result = (int) '�';
			break;
		case 'x':
			result = (int) '�';
			break;
		case '\\':
			result = (int) '�';
			break;
		case 'q':
			result = (int) '�';
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
