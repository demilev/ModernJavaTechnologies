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
			result = (int) 'à';
			break;
		case 'b':
			result = (int) 'á';
			break;
		case 'w':
			result = (int) 'â';
			break;
		case 'g':
			result = (int) 'ã';
			break;
		case 'd':
			result = (int) 'ä';
			break;
		case 'e':
			result = (int) 'å';
			break;
		case 'v':
			result = (int) 'æ';
			break;
		case 'z':
			result = (int) 'ç';
			break;
		case 'i':
			result = (int) 'è';
			break;
		case 'j':
			result = (int) 'é';
			break;
		case 'k':
			result = (int) 'ê';
			break;
		case 'l':
			result = (int) 'ë';
			break;
		case 'm':
			result = (int) 'ì';
			break;
		case 'n':
			result = (int) 'í';
			break;
		case 'o':
			result = (int) 'î';
			break;
		case 'p':
			result = (int) 'ï';
			break;
		case 'r':
			result = (int) 'ð';
			break;
		case 's':
			result = (int) 'ñ';
			break;
		case 't':
			result = (int) 'ò';
			break;
		case 'u':
			result = (int) 'ó';
			break;
		case 'f':
			result = (int) 'ô';
			break;
		case 'h':
			result = (int) 'õ';
			break;
		case 'c':
			result = (int) 'ö';
			break;
		case '`':
			result = (int) '÷';
			break;
		case '[':
			result = (int) 'ø';
			break;
		case ']':
			result = (int) 'ù';
			break;
		case 'y':
			result = (int) 'ú';
			break;
		case 'x':
			result = (int) 'ü';
			break;
		case '\\':
			result = (int) 'þ';
			break;
		case 'q':
			result = (int) 'ÿ';
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
