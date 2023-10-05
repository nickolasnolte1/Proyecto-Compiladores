// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: Scanner.jflex

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("fallthrough")
class GeneratedLexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\6\1\7\2\0\1\10\1\11\1\0\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\0\1\20\1\21\11\22"+
    "\1\0\1\23\1\24\1\25\1\26\2\0\6\27\24\30"+
    "\1\31\1\0\1\32\1\0\1\33\1\0\6\27\21\30"+
    "\1\34\2\30\1\35\1\36\1\37\7\0\1\3\u01a2\0"+
    "\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\2\1\4\1\1\1\5"+
    "\1\1\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\2\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\1\1\27\1\30\1\0\1\31\1\32"+
    "\1\33\1\15\1\34\1\35\1\36\1\37\2\40\1\41"+
    "\1\42\1\43\1\44\1\36\1\45";

  private static int [] zzUnpackAction() {
    int [] result = new int[47];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\40\0\40\0\40\0\100\0\140\0\200\0\40"+
    "\0\240\0\40\0\40\0\300\0\340\0\40\0\u0100\0\u0120"+
    "\0\u0140\0\u0160\0\40\0\u0180\0\u01a0\0\u01c0\0\u01e0\0\40"+
    "\0\40\0\u01e0\0\40\0\u0200\0\40\0\40\0\200\0\40"+
    "\0\40\0\40\0\u0220\0\40\0\40\0\u0240\0\40\0\u0260"+
    "\0\u0280\0\40\0\40\0\40\0\40\0\40\0\u0280";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[47];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\3\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\2\27"+
    "\1\30\1\31\1\32\1\27\1\33\1\34\1\35\42\0"+
    "\1\3\62\0\1\36\12\0\7\37\1\40\30\37\11\0"+
    "\1\41\53\0\1\42\33\0\2\43\2\0\1\44\33\0"+
    "\2\43\2\0\1\45\32\0\1\46\4\0\1\47\33\0"+
    "\2\22\4\0\2\50\2\0\1\50\1\51\24\0\2\22"+
    "\4\0\2\50\2\0\2\50\30\0\1\52\37\0\1\53"+
    "\37\0\1\54\33\0\2\32\4\0\2\32\2\0\2\32"+
    "\41\0\1\55\22\0\2\43\15\0\2\46\1\56\3\0"+
    "\32\46\21\0\2\50\4\0\2\50\2\0\2\50\24\0"+
    "\2\57\4\0\1\57\1\50\2\0\2\50\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[672];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\11\3\1\1\11\1\1\2\11\2\1\1\11"+
    "\4\1\1\11\4\1\2\11\1\1\1\11\1\1\2\11"+
    "\1\0\3\11\1\1\2\11\1\1\1\11\2\1\5\11"+
    "\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[47];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
private static final Set<String> keywords = new HashSet<>();

    static {
        keywords.add("class");
        keywords.add("while");
        keywords.add("int");
        keywords.add("if");
        keywords.add("else");
        keywords.add("break");
        keywords.add("boolean");
        keywords.add("void");
        keywords.add("for");
        keywords.add("return");
        keywords.add("true");
        keywords.add("false");
        keywords.add("continue");
        keywords.add("callout");
    }

    private boolean isKeyword(String text) {
        return keywords.contains(text);
    }









public enum TokenType {
        ID, NUM, CLASS, INT, BOOLEAN, VOID, IF, ELSE, WHILE, FOR, RETURN, TRUE, FALSE,
        BREAK, CONTINUE, SUMA, RESTA, MULTI, DIV, MOD, ASIG, EQUALS, NOTEQUALS,
        LESSTHAN, MORETHAN, LESSEQUALS, MOREEQUALS, AND, OR, NOT, PIZ, PDER, CIZ,
        CDER, LIZ, LDER, PUNTOCOMA, COMA, SCOMMENT, STRING, CHAR, SUMEQUAL, MINUSEQUAL,
        MULTEQUAL, DIVEQUAL, CALLOUT, HEXA, ERROR
}

public int currentCol;
public int currentRow;

private static final Map<String, GeneratedLexer.TokenType> keywordToTokenType = new HashMap<>();

    static {
        keywordToTokenType.put("if", TokenType.IF);
        keywordToTokenType.put("while", TokenType.WHILE);
        keywordToTokenType.put("int", TokenType.INT);
        keywordToTokenType.put("class", TokenType.CLASS);
        keywordToTokenType.put("boolean", TokenType.BOOLEAN);
        keywordToTokenType.put("void", TokenType.VOID);
        keywordToTokenType.put("else", TokenType.ELSE);
        keywordToTokenType.put("for", TokenType.FOR);
        keywordToTokenType.put("return", TokenType.RETURN);
        keywordToTokenType.put("true", TokenType.TRUE);
        keywordToTokenType.put("false", TokenType.FALSE);
        keywordToTokenType.put("break", TokenType.BREAK);
        keywordToTokenType.put("continue", TokenType.CONTINUE);
        keywordToTokenType.put("callout", TokenType.CALLOUT);
    }

    private TokenType getKeywordTokenType(String keyword) {
        return keywordToTokenType.getOrDefault(keyword, TokenType.ERROR); 
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  GeneratedLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) throws LexicalException {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexicalException(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  throws LexicalException {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token yylex() throws java.io.IOException,
     LexicalException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { currentCol++;
                                    return new Token(TokenType.ERROR, currentRow, currentCol, yytext());
            }
          // fall through
          case 38: break;
          case 2:
            { currentCol++;
            }
          // fall through
          case 39: break;
          case 3:
            { currentRow++;
    currentCol = 1;
            }
          // fall through
          case 40: break;
          case 4:
            { currentCol++;
                                    return new Token(TokenType.NOT, currentRow, currentCol, yytext());
            }
          // fall through
          case 41: break;
          case 5:
            { currentCol++;
                                    return new Token(TokenType.MOD, currentRow, currentCol, yytext());
            }
          // fall through
          case 42: break;
          case 6:
            { currentCol++;
                                    return new Token(TokenType.PIZ, currentRow, currentCol, yytext());
            }
          // fall through
          case 43: break;
          case 7:
            { currentCol++;
                                    return new Token(TokenType.PDER, currentRow, currentCol, yytext());
            }
          // fall through
          case 44: break;
          case 8:
            { currentCol++;   
                                    return new Token(TokenType.MULTI, currentRow, currentCol, yytext());
            }
          // fall through
          case 45: break;
          case 9:
            { currentCol++;   
                                    return new Token(TokenType.SUMA, currentRow, currentCol, yytext());
            }
          // fall through
          case 46: break;
          case 10:
            { currentCol++;
                                    return new Token(TokenType.COMA, currentRow, currentCol, yytext());
            }
          // fall through
          case 47: break;
          case 11:
            { currentCol++;   
                                    return new Token(TokenType.RESTA, currentRow, currentCol, yytext());
            }
          // fall through
          case 48: break;
          case 12:
            { currentCol++;
                                    return new Token(TokenType.DIV, currentRow, currentCol, yytext());
            }
          // fall through
          case 49: break;
          case 13:
            { currentCol++;
                                    return new Token(TokenType.NUM, currentRow, currentCol, yytext());
            }
          // fall through
          case 50: break;
          case 14:
            { currentCol++;
                                    return new Token(TokenType.PUNTOCOMA, currentRow, currentCol, yytext());
            }
          // fall through
          case 51: break;
          case 15:
            { currentCol++;
                                    return new Token(TokenType.LESSTHAN, currentRow, currentCol, yytext());
            }
          // fall through
          case 52: break;
          case 16:
            { currentCol++;
                                    return new Token(TokenType.ASIG, currentRow, currentCol, yytext());
            }
          // fall through
          case 53: break;
          case 17:
            { currentCol++;
                                    return new Token(TokenType.MORETHAN, currentRow, currentCol, yytext());
            }
          // fall through
          case 54: break;
          case 18:
            { currentCol++;
                                    return new Token(TokenType.CHAR, currentRow, currentCol, yytext());
            }
          // fall through
          case 55: break;
          case 19:
            { currentCol++;
                                    return new Token(TokenType.CIZ, currentRow, currentCol, yytext());
            }
          // fall through
          case 56: break;
          case 20:
            { currentCol++;
                                    return new Token(TokenType.CDER, currentRow, currentCol, yytext());
            }
          // fall through
          case 57: break;
          case 21:
            { // Check if the matched text is a keyword or a variable
    String lexeme = yytext();
    if (isKeyword(lexeme)) {
        currentCol++;  
        return new Token(getKeywordTokenType(lexeme), currentRow, currentCol,lexeme);
    } else {
        currentCol++;  
        return new Token(TokenType.ID, currentRow, currentCol,lexeme);
    }
            }
          // fall through
          case 58: break;
          case 22:
            { return new Token(TokenType.LIZ, currentRow, currentCol, yytext());
            }
          // fall through
          case 59: break;
          case 23:
            { currentCol++;
                                    return new Token(TokenType.LDER, currentRow, currentCol, yytext());
            }
          // fall through
          case 60: break;
          case 24:
            { currentCol++;
                                    return new Token(TokenType.NOTEQUALS, currentRow, currentCol, yytext());
            }
          // fall through
          case 61: break;
          case 25:
            { currentCol++;  
                                    return new Token(TokenType.STRING, currentRow, currentCol, yytext());
            }
          // fall through
          case 62: break;
          case 26:
            { currentCol++;
                                    return new Token(TokenType.AND, currentRow, currentCol, yytext());
            }
          // fall through
          case 63: break;
          case 27:
            { currentCol++;
                                    return new Token(TokenType.MULTEQUAL, currentRow, currentCol, yytext());
            }
          // fall through
          case 64: break;
          case 28:
            { currentCol++;
                                    return new Token(TokenType.SUMEQUAL, currentRow, currentCol, yytext());
            }
          // fall through
          case 65: break;
          case 29:
            { currentCol++;
                                    return new Token(TokenType.MINUSEQUAL, currentRow, currentCol, yytext());
            }
          // fall through
          case 66: break;
          case 30:
            { currentCol++;
                                    return new Token(TokenType.SCOMMENT, currentRow, currentCol, yytext());
            }
          // fall through
          case 67: break;
          case 31:
            { currentCol++;
                                    return new Token(TokenType.DIVEQUAL, currentRow, currentCol, yytext());
            }
          // fall through
          case 68: break;
          case 32:
            { currentCol++;  
                                    return new Token(TokenType.ERROR, currentRow, currentCol, yytext());
            }
          // fall through
          case 69: break;
          case 33:
            { currentCol++;
                                    return new Token(TokenType.LESSEQUALS, currentRow, currentCol, yytext());
            }
          // fall through
          case 70: break;
          case 34:
            { currentCol++;
                                    return new Token(TokenType.EQUALS, currentRow, currentCol, yytext());
            }
          // fall through
          case 71: break;
          case 35:
            { currentCol++; 
                                    return new Token(TokenType.MOREEQUALS, currentRow, currentCol, yytext());
            }
          // fall through
          case 72: break;
          case 36:
            { currentCol++;
                                    return new Token(TokenType.OR, currentRow, currentCol, yytext());
            }
          // fall through
          case 73: break;
          case 37:
            { currentCol++;
                                    return new Token(TokenType.HEXA, currentRow, currentCol, yytext());
            }
          // fall through
          case 74: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
