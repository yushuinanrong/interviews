package mathematics.bigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WhatBaseIsThis {

    static void solve() throws Exception {
	Scanner input = new Scanner(System.in);
	while (input.hasNext()) {
	    String x = input.next();
	    String y = input.next();
	    boolean found = false;
	    for (int i = 2; i < 37 && !found; i++) {
		BigInteger xConvertedToBase;
		try {
		    xConvertedToBase = new BigInteger(x, i);
		} catch (Exception e) {
		    continue;
		}
		for (int j = 2; j < 37; j++) {
		    BigInteger yConvertedToBase;
		    try {
			yConvertedToBase = new BigInteger(y, j);
		    } catch (Exception e) {
			continue;
		    }
		    if (xConvertedToBase.equals(yConvertedToBase)) {
			System.out.println(x + " (base " + i  + ") = " + y + " (base " + j + ")");
			found = true;
			break;
		    }
		}
	    }
	    if (!found) {
		System.out.println(x + " is not equal to " + y + " in any base 2..36");
	    }
	}
	input.close();
    }

    static int nextInt() throws IOException {
	return parseInt(next());
    }

    static String next() throws IOException {
	while (tok == null || !tok.hasMoreTokens()) {
	    tok = new StringTokenizer(in.readLine());
	}
	return tok.nextToken();
    }

    public static void main(String[] args) {
	try {
	    in = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(new OutputStreamWriter(System.out));
	    solve();
	    in.close();
	    out.close();
	} catch (Throwable e) {
	    e.printStackTrace();
	    exit(0);
	}
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
}
