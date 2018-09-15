package com.it.common.uitl.uitls;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PWD {
     //private Log log= LogFactory.getLog(PWD.class);
	private static final String DESEDEKEY = "SuNlInE+9sUnITs+9DesKEys";
	private static final String ALGORITHM = "DESede";

//	public static void main(String[] args) {
//		String aaa = enc("6981");
//
//		aaa = aaa.replaceAll("=", "#");
//		System.out.println(aaa);
//		aaa = aaa.replaceAll( "#","=");
//		System.out.println(dec("u4 syo9KAro#"));
//	}
	public static String appenc(String myinfo) {
		try {
			SecretKey key = new SecretKeySpec(DESEDEKEY.getBytes(), ALGORITHM);
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherByte = c1.doFinal(myinfo.getBytes());
			// BASE64Encoder encoder = new BASE64Encoder();
			// String r = encoder.encode(cipherByte);
			String cipherString = Base64Self.encode(cipherByte);

			cipherString = cipherString.replaceAll("=", "#");

			return cipherString;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static String appdec(String myinfo) {
		try {
			// BASE64Decoder decoder = new BASE64Decoder();
			// byte[] bs = decoder.decodeBuffer(myinfo);
			myinfo = myinfo.replaceAll("#", "=");

			byte[] bs = Base64Self.decode(myinfo);
			SecretKey key = new SecretKeySpec(DESEDEKEY.getBytes(), ALGORITHM);
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.DECRYPT_MODE, key);
			byte[] clearByte = c1.doFinal(bs);
			return new String(clearByte);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
	public static String enc(String myinfo) {
		try {
			SecretKey key = new SecretKeySpec(DESEDEKEY.getBytes(), ALGORITHM);
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherByte = c1.doFinal(myinfo.getBytes());
			// BASE64Encoder encoder = new BASE64Encoder();
			// String r = encoder.encode(cipherByte);
			String cipherString = Base64Self.encode(cipherByte);

			cipherString = cipherString.replaceAll("=", "#");

			return cipherString;
		} catch (Throwable e) {
		     // log.info(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static String dec(String myinfo) {
		try {
			
			// BASE64Decoder decoder = new BASE64Decoder();
			// byte[] bs = decoder.decodeBuffer(myinfo);
			myinfo = myinfo.replaceAll("#", "=");

			byte[] bs = Base64Self.decode(myinfo);
			SecretKey key = new SecretKeySpec(DESEDEKEY.getBytes(), ALGORITHM);
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.DECRYPT_MODE, key);
			byte[] clearByte = c1.doFinal(bs);
			return new String(clearByte);
		} catch (Exception e1) {
			try {
				if(myinfo!=null) {
					if(myinfo.indexOf(" ")>0) {
						myinfo =myinfo.replaceAll(" ", "+");
					}
				}
				myinfo = myinfo.replaceAll("#", "=");

				byte[] bs = Base64Self.decode(myinfo);
				SecretKey key = new SecretKeySpec(DESEDEKEY.getBytes(), ALGORITHM);
				Cipher c1 = Cipher.getInstance(ALGORITHM);
				c1.init(Cipher.DECRYPT_MODE, key);
				byte[] clearByte = c1.doFinal(bs);
				return new String(clearByte);
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
	
		}
	}

	public static String base64Encode(byte bytes[]) {
		if (bytes == null)
			return "";
		else
			return Base64Self.encode(bytes);
	}

	// public static byte[] base64Decode(String text) throws IOException {
	// if (text == null)
	// return new byte[0];
	// else
	// return (new BASE64Decoder()).decodeBuffer(text);
	// }
	//
	// public static String decryptByDES(String cryptograph, String keyString)
	// {
	// byte bytes[];
	// byte key[];
	// if(cryptograph == null)
	// return null;
	// bytes = base64Decode(cryptograph);
	// key = DEFAULT_DES_KEY;
	// if(!StringUtil.isBlank(keyString))
	// key = fixToBytes(keyString, 8);
	// return new String(com.eos.system.utility.CryptoUtil.decrypt(bytes, key,
	// com.eos.system.utility.CryptoUtil.DES_ALGORITHM));
	// Exception e;
	// e;
	// throw new EOSRuntimeException("24000011", new String[] {
	// e.getMessage()
	// });
	// }
	//
	// public static String encryptByDES(String plainText, String keyString)
	// {
	// byte key[];
	// if(plainText == null)
	// return null;
	// key = DEFAULT_DES_KEY;
	// if(!StringUtil.isBlank(keyString))
	// key = fixToBytes(keyString, 8);
	// byte cryptograph[] =
	// com.eos.system.utility.CryptoUtil.encrypt(plainText.getBytes(), key,
	// com.eos.system.utility.CryptoUtil.DES_ALGORITHM);
	// return base64Encode(cryptograph);
	// Exception e;
	// e;
	// throw new EOSRuntimeException("24000012", new String[] {
	// e.getMessage()
	// });
	// }

	public static byte[] md5(byte input[]) throws NoSuchAlgorithmException {
		MessageDigest alg = MessageDigest.getInstance("MD5");
		alg.update(input);
		byte digest[] = alg.digest();
		return digest;
	}


	// public static String digestBySHA(String text)
	// {
	// if(text == null)
	// return null;
	// byte digest[];
	// MessageDigest alg = MessageDigest.getInstance("SHA");
	// alg.update(text.getBytes());
	// digest = alg.digest();
	// return base64Encode(digest);
	// NoSuchAlgorithmException e;
	// e;
	// throw new EOSRuntimeException("24000014", new String[] {
	// e.getMessage()
	// });
	// }

	// private static final byte[] fixToBytes(String s, int destLength)
	// {
	// byte bytes[] = s.getBytes();
	// int xLength = destLength - bytes.length;
	// if(xLength == 0)
	// return bytes;
	// if(xLength > 0)
	// {
	// byte result[] = new byte[destLength];
	// System.arraycopy(bytes, 0, result, 0, bytes.length);
	// return result;
	// } else
	// {
	// byte result[] = new byte[destLength];
	// System.arraycopy(bytes, 0, result, 0, destLength - 1);
	// return result;
	// }
	// }

	// public static final byte DEFAULT_DES_KEY[] = {
	// -99, 118, 97, -105, -51, -17, 81, 14
	// };

}

class Base64Self {

	/** Field BASE64DEFAULTLENGTH */
	public static final int BASE64DEFAULTLENGTH = 76;

	/** Field _base64length */
	static int _base64length = BASE64DEFAULTLENGTH;

	private Base64Self() {
		// we don't allow instantiation
	}

	/**
	 * Returns a byte-array representation of a <code>{@link BigInteger}<code>.
	 * No sign-bit is outputed.
	 *
	 * <b>N.B.:</B> <code>{@link BigInteger}<code>'s toByteArray
	 * retunrs eventually longer arrays because of the leading sign-bit.
	 *
	 * @param big
	 *            <code>BigInteger<code> to be converted
	 * @param bitlen
	 *            <code>int<code> the desired length in bits of the
	 *            representation
	 * @return a byte array with <code>bitlen</code> bits of <code>big</code>
	 */
	static byte[] getBytes(BigInteger big, int bitlen) {

		// round bitlen
		bitlen = ((bitlen + 7) >> 3) << 3;

		if (bitlen < big.bitLength()) {
			throw new IllegalArgumentException("utils.Base64.IllegalBitlength");
		}

		byte[] bigBytes = big.toByteArray();

		if (((big.bitLength() % 8) != 0)
				&& (((big.bitLength() / 8) + 1) == (bitlen / 8))) {
			return bigBytes;
		}

		// some copying needed
		int startSrc = 0; // no need to skip anything
		int bigLen = bigBytes.length; // valid length of the string

		if ((big.bitLength() % 8) == 0) { // correct values
			startSrc = 1; // skip sign bit

			bigLen--; // valid length of the string
		}

		int startDst = bitlen / 8 - bigLen; // pad with leading nulls
		byte[] resizedBytes = new byte[bitlen / 8];

		System.arraycopy(bigBytes, startSrc, resizedBytes, startDst, bigLen);

		return resizedBytes;

	}

	/**
	 * Encode in Base64 the given <code>{@link BigInteger}<code>.
	 *
	 * @param big
	 * @return String with Base64 encoding
	 */
	public static String encode(BigInteger big) {
		return encode(getBytes(big, big.bitLength()));
	}

	/**
	 * Returns a byte-array representation of a <code>{@link BigInteger}<code>.
	 * No sign-bit is outputed.
	 *
	 * <b>N.B.:</B> <code>{@link BigInteger}<code>'s toByteArray
	 * retunrs eventually longer arrays because of the leading sign-bit.
	 *
	 * @param big
	 *            <code>BigInteger<code> to be converted
	 * @param bitlen
	 *            <code>int<code> the desired length in bits of the
	 *            representation
	 * @return a byte array with <code>bitlen</code> bits of <code>big</code>
	 */
	public static byte[] encode(BigInteger big, int bitlen) {

		// round bitlen
		bitlen = ((bitlen + 7) >> 3) << 3;

		if (bitlen < big.bitLength()) {
			throw new IllegalArgumentException("utils.Base64.IllegalBitlength");
		}

		byte[] bigBytes = big.toByteArray();

		if (((big.bitLength() % 8) != 0)
				&& (((big.bitLength() / 8) + 1) == (bitlen / 8))) {
			return bigBytes;
		}

		// some copying needed
		int startSrc = 0; // no need to skip anything
		int bigLen = bigBytes.length; // valid length of the string

		if ((big.bitLength() % 8) == 0) { // correct values
			startSrc = 1; // skip sign bit

			bigLen--; // valid length of the string
		}

		int startDst = bitlen / 8 - bigLen; // pad with leading nulls
		byte[] resizedBytes = new byte[bitlen / 8];

		System.arraycopy(bigBytes, startSrc, resizedBytes, startDst, bigLen);

		return resizedBytes;

	}

	// /**
	// * Method decodeBigIntegerFromElement
	// *
	// * @param element
	// * @return the biginter obtained from the node
	// * @throws Exception
	// */
	// public static BigInteger decodeBigIntegerFromElement(Element element)
	// throws Exception
	// {
	// return new BigInteger(1, decode(element));
	// }
	//
	// /**
	// * Method decodeBigIntegerFromText
	// *
	// * @param text
	// * @return the biginter obtained from the text node
	// * @throws Exception
	// */
	// public static BigInteger decodeBigIntegerFromText(Text text) throws
	// Exception
	// {
	// return new BigInteger(1, decode(text.getData()));
	// }

	// /**
	// * This method takes an (empty) Element and a BigInteger and adds the
	// * base64 encoded BigInteger to the Element.
	// *
	// * @param element
	// * @param biginteger
	// */
	// public static void fillElementWithBigInteger(Element element,
	// BigInteger biginteger) {
	//
	// String encodedInt = encode(biginteger);
	//
	// if (encodedInt.length() > 76) {
	// encodedInt = "\n" + encodedInt + "\n";
	// }
	//
	// Document doc = element.getOwnerDocument();
	// Text text = doc.createTextNode(encodedInt);
	//
	// element.appendChild(text);
	// }

	// /**
	// * Method decode
	// *
	// * Takes the <CODE>Text</CODE> children of the Element and interprets
	// * them as input for the <CODE>Base64.decode()</CODE> function.
	// *
	// * @param element
	// * @return the byte obtained of the decoding the element
	// * $todo$ not tested yet
	// * @throws Exception
	// */
	// public static byte[] decode(Element element) throws Exception {
	//
	// Node sibling = element.getFirstChild();
	// StringBuffer sb = new StringBuffer();
	//
	// while (sibling!=null) {
	// if (sibling.getNodeType() == Node.TEXT_NODE) {
	// Text t = (Text) sibling;
	//
	// sb.append(t.getData());
	// }
	// sibling=sibling.getNextSibling();
	// }
	//
	// return decode(sb.toString());
	// }

	// /**
	// * Method encodeToElement
	// *
	// * @param doc
	// * @param localName
	// * @param bytes
	// * @return an Element with the base64 encoded in the text.
	// *
	// */
	// public static Element encodeToElement(Document doc, String localName,
	// byte[] bytes) {
	//
	// Element el = XMLUtils.createElementInSignatureSpace(doc, localName);
	// Text text = doc.createTextNode(encode(bytes));
	//
	// el.appendChild(text);
	//
	// return el;
	// }

	/**
	 * Method decode
	 *
	 *
	 * @param base64
	 * @return the UTF bytes of the base64
	 * @throws Exception
	 *
	 */
	public static byte[] decode(byte[] base64) throws Exception {
		return decodeInternal(base64);
	}

	/**
	 * Encode a byte array and fold lines at the standard 76th character.
	 *
	 * @param binaryData
	 *            <code>byte[]<code> to be base64 encoded
	 * @return the <code>String<code> with encoded data
	 */
	public static String encode(byte[] binaryData) {
		return encode(binaryData, BASE64DEFAULTLENGTH);
	}

	// /**
	// * Base64 decode the lines from the reader and return an InputStream
	// * with the bytes.
	// *
	// *
	// * @param reader
	// * @return InputStream with the decoded bytes
	// * @exception IOException passes what the reader throws
	// * @throws IOException
	// * @throws Exception
	// */
	// public static byte[] decode(BufferedReader reader)
	// throws IOException, Exception {
	//
	// UnsyncByteArrayOutputStream baos = new UnsyncByteArrayOutputStream();
	// String line;
	//
	// while (null != (line = reader.readLine())) {
	// byte[] bytes = decode(line);
	//
	// baos.write(bytes);
	// }
	//
	// return baos.toByteArray();
	// }

	// /**
	// * Method main
	// *
	// *
	// * @param args
	// *
	// * @throws Exception
	// */
	// public static void main(String[] args) throws Exception {
	//
	// DocumentBuilderFactory docBuilderFactory =
	// DocumentBuilderFactory.newInstance();
	// DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	// String testString1 =
	// "<container><base64 value=\"Should be 'Hallo'\">SGFsbG8=</base64></container>";
	// InputSource inputSource = new InputSource(new StringReader(testString1));
	// Document doc = docBuilder.parse(inputSource);
	// Element base64Elem =
	// (Element) doc.getDocumentElement().getChildNodes().item(0);
	//
	// System.out.println(new String(decode(base64Elem)));
	// }
	static private final int BASELENGTH = 255;
	static private final int LOOKUPLENGTH = 64;
	static private final int TWENTYFOURBITGROUP = 24;
	static private final int EIGHTBIT = 8;
	static private final int SIXTEENBIT = 16;
	static private final int FOURBYTE = 4;
	static private final int SIGN = -128;
	static private final char PAD = '=';
	static private final boolean fDebug = false;
	static final private byte[] base64Alphabet = new byte[BASELENGTH];
	static final private char[] lookUpBase64Alphabet = new char[LOOKUPLENGTH];

	static {

		for (int i = 0; i < BASELENGTH; i++) {
			base64Alphabet[i] = -1;
		}
		for (int i = 'Z'; i >= 'A'; i--) {
			base64Alphabet[i] = (byte) (i - 'A');
		}
		for (int i = 'z'; i >= 'a'; i--) {
			base64Alphabet[i] = (byte) (i - 'a' + 26);
		}

		for (int i = '9'; i >= '0'; i--) {
			base64Alphabet[i] = (byte) (i - '0' + 52);
		}

		base64Alphabet['+'] = 62;
		base64Alphabet['/'] = 63;

		for (int i = 0; i <= 25; i++)
			lookUpBase64Alphabet[i] = (char) ('A' + i);

		for (int i = 26, j = 0; i <= 51; i++, j++)
			lookUpBase64Alphabet[i] = (char) ('a' + j);

		for (int i = 52, j = 0; i <= 61; i++, j++)
			lookUpBase64Alphabet[i] = (char) ('0' + j);
		lookUpBase64Alphabet[62] = '+';
		lookUpBase64Alphabet[63] = '/';

	}

	protected static final boolean isWhiteSpace(byte octect) {
		return (octect == 0x20 || octect == 0xd || octect == 0xa || octect == 0x9);
	}

	protected static final boolean isPad(byte octect) {
		return (octect == PAD);
	}

	/**
	 * Encodes hex octects into Base64
	 *
	 * @param binaryData
	 *            Array containing binaryData
	 * @return Encoded Base64 array
	 */
	/**
	 * Encode a byte array in Base64 format and return an optionally wrapped
	 * line.
	 *
	 * @param binaryData
	 *            <code>byte[]</code> data to be encoded
	 * @param length
	 *            <code>int<code> length of wrapped lines; No wrapping if less than 4.
	 * @return a <code>String</code> with encoded data
	 */
	public static String encode(byte[] binaryData, int length) {

		if (length < 4) {
			length = Integer.MAX_VALUE;
		}

		if (binaryData == null)
			return null;

		int lengthDataBits = binaryData.length * EIGHTBIT;
		if (lengthDataBits == 0) {
			return "";
		}

		int fewerThan24bits = lengthDataBits % TWENTYFOURBITGROUP;
		int numberTriplets = lengthDataBits / TWENTYFOURBITGROUP;
		int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1
				: numberTriplets;
		int quartesPerLine = length / 4;
		int numberLines = (numberQuartet - 1) / quartesPerLine;
		char encodedData[] = null;

		encodedData = new char[numberQuartet * 4 + numberLines];

		byte k = 0, l = 0, b1 = 0, b2 = 0, b3 = 0;

		int encodedIndex = 0;
		int dataIndex = 0;
		int i = 0;
		if (fDebug) {
			System.out.println("number of triplets = " + numberTriplets);
		}

		for (int line = 0; line < numberLines; line++) {
			for (int quartet = 0; quartet < 19; quartet++) {
				b1 = binaryData[dataIndex++];
				b2 = binaryData[dataIndex++];
				b3 = binaryData[dataIndex++];

				if (fDebug) {
					System.out.println("b1= " + b1 + ", b2= " + b2 + ", b3= "
							+ b3);
				}

				l = (byte) (b2 & 0x0f);
				k = (byte) (b1 & 0x03);

				byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
						: (byte) ((b1) >> 2 ^ 0xc0);

				byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4)
						: (byte) ((b2) >> 4 ^ 0xf0);
				byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6)
						: (byte) ((b3) >> 6 ^ 0xfc);

				if (fDebug) {
					System.out.println("val2 = " + val2);
					System.out.println("k4   = " + (k << 4));
					System.out.println("vak  = " + (val2 | (k << 4)));
				}

				encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[val2
						| (k << 4)];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[(l << 2)
						| val3];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[b3 & 0x3f];

				i++;
			}
			encodedData[encodedIndex++] = 0xa;
		}

		for (; i < numberTriplets; i++) {
			b1 = binaryData[dataIndex++];
			b2 = binaryData[dataIndex++];
			b3 = binaryData[dataIndex++];

			if (fDebug) {
				System.out.println("b1= " + b1 + ", b2= " + b2 + ", b3= " + b3);
			}

			l = (byte) (b2 & 0x0f);
			k = (byte) (b1 & 0x03);

			byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
					: (byte) ((b1) >> 2 ^ 0xc0);

			byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4)
					: (byte) ((b2) >> 4 ^ 0xf0);
			byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6)
					: (byte) ((b3) >> 6 ^ 0xfc);

			if (fDebug) {
				System.out.println("val2 = " + val2);
				System.out.println("k4   = " + (k << 4));
				System.out.println("vak  = " + (val2 | (k << 4)));
			}

			encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[val2 | (k << 4)];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[(l << 2) | val3];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[b3 & 0x3f];
		}

		// form integral number of 6-bit groups
		if (fewerThan24bits == EIGHTBIT) {
			b1 = binaryData[dataIndex];
			k = (byte) (b1 & 0x03);
			if (fDebug) {
				System.out.println("b1=" + b1);
				System.out.println("b1<<2 = " + (b1 >> 2));
			}
			byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
					: (byte) ((b1) >> 2 ^ 0xc0);
			encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[k << 4];
			encodedData[encodedIndex++] = PAD;
			encodedData[encodedIndex++] = PAD;
		} else if (fewerThan24bits == SIXTEENBIT) {
			b1 = binaryData[dataIndex];
			b2 = binaryData[dataIndex + 1];
			l = (byte) (b2 & 0x0f);
			k = (byte) (b1 & 0x03);

			byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
					: (byte) ((b1) >> 2 ^ 0xc0);
			byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4)
					: (byte) ((b2) >> 4 ^ 0xf0);

			encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[val2 | (k << 4)];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[l << 2];
			encodedData[encodedIndex++] = PAD;
		}

		// encodedData[encodedIndex] = 0xa;

		return new String(encodedData);
	}

	/**
	 * Decodes Base64 data into octects
	 *
	 * @param encoded
	 *            Byte array containing Base64 data
	 * @return Array containind decoded data.
	 * @throws Exception
	 */
	public final static byte[] decode(String encoded) throws Exception {

		if (encoded == null)
			return null;

		return decodeInternal(encoded.getBytes());
	}

	protected final static byte[] decodeInternal(byte[] base64Data)
			throws Exception {
		// remove white spaces
		int len = removeWhiteSpace(base64Data);

		if (len % FOURBYTE != 0) {
			throw new Exception("decoding.divisible.four");
			// should be divisible by four
		}

		int numberQuadruple = (len / FOURBYTE);

		if (numberQuadruple == 0)
			return new byte[0];

		byte decodedData[] = null;
		byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;

		int i = 0;
		int encodedIndex = 0;
		int dataIndex = 0;

		// decodedData = new byte[ (numberQuadruple)*3];
		dataIndex = (numberQuadruple - 1) * 4;
		encodedIndex = (numberQuadruple - 1) * 3;
		// first last bits.
		b1 = base64Alphabet[base64Data[dataIndex++]];
		b2 = base64Alphabet[base64Data[dataIndex++]];
		if ((b1 == -1) || (b2 == -1)) {
			throw new Exception("decoding.general");// if found "no data" just
													// return null
		}

		byte d3, d4;
		b3 = base64Alphabet[d3 = base64Data[dataIndex++]];
		b4 = base64Alphabet[d4 = base64Data[dataIndex++]];
		if ((b3 == -1) || (b4 == -1)) {
			// Check if they are PAD characters
			if (isPad(d3) && isPad(d4)) { // Two PAD e.g. 3c[Pad][Pad]
				if ((b2 & 0xf) != 0)// last 4 bits should be zero
					throw new Exception("decoding.general");
				decodedData = new byte[encodedIndex + 1];
				decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
			} else if (!isPad(d3) && isPad(d4)) { // One PAD e.g. 3cQ[Pad]
				if ((b3 & 0x3) != 0)// last 2 bits should be zero
					throw new Exception("decoding.general");
				decodedData = new byte[encodedIndex + 2];
				decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
				decodedData[encodedIndex] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
			} else {
				throw new Exception("decoding.general");// an error like
														// "3c[Pad]r", "3cdX",
														// "3cXd", "3cXX" where
														// X is non data
			}
		} else {
			// No PAD e.g 3cQl
			decodedData = new byte[encodedIndex + 3];
			decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
			decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
			decodedData[encodedIndex++] = (byte) (b3 << 6 | b4);
		}
		encodedIndex = 0;
		dataIndex = 0;
		// the begin
		for (i = numberQuadruple - 1; i > 0; i--) {
			b1 = base64Alphabet[base64Data[dataIndex++]];
			b2 = base64Alphabet[base64Data[dataIndex++]];
			b3 = base64Alphabet[base64Data[dataIndex++]];
			b4 = base64Alphabet[base64Data[dataIndex++]];

			if ((b1 == -1) || (b2 == -1) || (b3 == -1) || (b4 == -1)) {
				throw new Exception("decoding.general");// if found "no data"
														// just return null
			}

			decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
			decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
			decodedData[encodedIndex++] = (byte) (b3 << 6 | b4);
		}
		return decodedData;
	}

	/**
	 * Decodes Base64 data into outputstream
	 *
	 * @param base64Data
	 *            Byte array containing Base64 data
	 * @param os
	 *            the outputstream
	 * @throws IOException
	 * @throws Exception
	 */
	public final static void decode(byte[] base64Data, OutputStream os)
			throws Exception, IOException {
		// remove white spaces
		int len = removeWhiteSpace(base64Data);

		if (len % FOURBYTE != 0) {
			throw new Exception("decoding.divisible.four");
			// should be divisible by four
		}

		int numberQuadruple = (len / FOURBYTE);

		if (numberQuadruple == 0)
			return;

		// byte decodedData[] = null;
		byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;

		int i = 0;

		int dataIndex = 0;

		// the begin
		for (i = numberQuadruple - 1; i > 0; i--) {
			b1 = base64Alphabet[base64Data[dataIndex++]];
			b2 = base64Alphabet[base64Data[dataIndex++]];
			b3 = base64Alphabet[base64Data[dataIndex++]];
			b4 = base64Alphabet[base64Data[dataIndex++]];
			if ((b1 == -1) || (b2 == -1) || (b3 == -1) || (b4 == -1))
				throw new Exception("decoding.general");// if found "no data"
														// just return null

			os.write((byte) (b1 << 2 | b2 >> 4));
			os.write((byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf)));
			os.write((byte) (b3 << 6 | b4));
		}
		b1 = base64Alphabet[base64Data[dataIndex++]];
		b2 = base64Alphabet[base64Data[dataIndex++]];

		// first last bits.
		if ((b1 == -1) || (b2 == -1)) {
			throw new Exception("decoding.general");// if found "no data" just
													// return null
		}

		byte d3, d4;
		b3 = base64Alphabet[d3 = base64Data[dataIndex++]];
		b4 = base64Alphabet[d4 = base64Data[dataIndex++]];
		if ((b3 == -1) || (b4 == -1)) {// Check if they are PAD characters
			if (isPad(d3) && isPad(d4)) { // Two PAD e.g. 3c[Pad][Pad]
				if ((b2 & 0xf) != 0)// last 4 bits should be zero
					throw new Exception("decoding.general");
				os.write((byte) (b1 << 2 | b2 >> 4));
			} else if (!isPad(d3) && isPad(d4)) { // One PAD e.g. 3cQ[Pad]
				if ((b3 & 0x3) != 0)// last 2 bits should be zero
					throw new Exception("decoding.general");
				os.write((byte) (b1 << 2 | b2 >> 4));
				os.write((byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf)));
			} else {
				throw new Exception("decoding.general");// an error like
														// "3c[Pad]r", "3cdX",
														// "3cXd", "3cXX" where
														// X is non data
			}
		} else {
			// No PAD e.g 3cQl
			os.write((byte) (b1 << 2 | b2 >> 4));
			os.write((byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf)));
			os.write((byte) (b3 << 6 | b4));
		}
		return;
	}

	/**
	 * Decodes Base64 data into outputstream
	 *
	 * @param is
	 *            containing Base64 data
	 * @param os
	 *            the outputstream
	 * @throws IOException
	 * @throws Exception
	 */
	public final static void decode(InputStream is, OutputStream os)
			throws Exception, IOException {
		// byte decodedData[] = null;
		byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;

		int index = 0;
		byte[] data = new byte[4];
		int read;
		// the begin
		while ((read = is.read()) > 0) {
			byte readed = (byte) read;
			if (isWhiteSpace(readed)) {
				continue;
			}
			if (isPad(readed)) {
				data[index++] = readed;
				if (index == 3)
					data[index++] = (byte) is.read();
				break;
			}

			if ((data[index++] = readed) == -1) {
				throw new Exception("decoding.general");// if found "no data"
														// just return null
			}

			if (index != 4) {
				continue;
			}
			index = 0;
			b1 = base64Alphabet[data[0]];
			b2 = base64Alphabet[data[1]];
			b3 = base64Alphabet[data[2]];
			b4 = base64Alphabet[data[3]];

			os.write((byte) (b1 << 2 | b2 >> 4));
			os.write((byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf)));
			os.write((byte) (b3 << 6 | b4));
		}

		byte d1 = data[0], d2 = data[1], d3 = data[2], d4 = data[3];
		b1 = base64Alphabet[d1];
		b2 = base64Alphabet[d2];
		b3 = base64Alphabet[d3];
		b4 = base64Alphabet[d4];
		if ((b3 == -1) || (b4 == -1)) {// Check if they are PAD characters
			if (isPad(d3) && isPad(d4)) { // Two PAD e.g. 3c[Pad][Pad]
				if ((b2 & 0xf) != 0)// last 4 bits should be zero
					throw new Exception("decoding.general");
				os.write((byte) (b1 << 2 | b2 >> 4));
			} else if (!isPad(d3) && isPad(d4)) { // One PAD e.g. 3cQ[Pad]
				b3 = base64Alphabet[d3];
				if ((b3 & 0x3) != 0)// last 2 bits should be zero
					throw new Exception("decoding.general");
				os.write((byte) (b1 << 2 | b2 >> 4));
				os.write((byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf)));
			} else {
				throw new Exception("decoding.general");// an error like
														// "3c[Pad]r", "3cdX",
														// "3cXd", "3cXX" where
														// X is non data
			}
		} else {
			// No PAD e.g 3cQl

			os.write((byte) (b1 << 2 | b2 >> 4));
			os.write((byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf)));
			os.write((byte) (b3 << 6 | b4));
		}

		return;
	}

	/**
	 * remove WhiteSpace from MIME containing encoded Base64 data.
	 *
	 * @param data
	 *            the byte array of base64 data (with WS)
	 * @return the new length
	 */
	protected static int removeWhiteSpace(byte[] data) {
		if (data == null)
			return 0;

		// count characters that's not whitespace
		int newSize = 0;
		int len = data.length;
		for (int i = 0; i < len; i++) {
			byte dataS = data[i];
			if (!isWhiteSpace(dataS))
				data[newSize++] = dataS;
		}
		return newSize;
	}
}
