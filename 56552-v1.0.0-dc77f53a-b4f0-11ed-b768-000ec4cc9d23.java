/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__fromDB_15.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 606 Unchecked Input for Loop Condition
* BadSource: fromDB Read a string from a database connection
* GoodSource: hardcoded int in string form
* Sinks:
*    GoodSink: validate loop variable
*    BadSink : loop variable not validated
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE606_Unchecked_Loop_Condition__fromDB_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* setup the connection */
                conn = IO.getDBConnection();
                /* prepare the query */
                statement = conn.prepareStatement("select name from users where id=?");
                /* get user input for the userid */
                IO.writeLine("Enter a userid to login as (number): ");
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                int num = Integer.parseInt(buffread.readLine());
                statement.setInt(1, num);
                rs = statement.executeQuery();
                data = rs.getString(1);
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = "5";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* setup the connection */
                conn = IO.getDBConnection();
                /* prepare the query */
                statement = conn.prepareStatement("select name from users where id=?");
                /* get user input for the userid */
                IO.writeLine("Enter a userid to login as (number): ");
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                int num = Integer.parseInt(buffread.readLine());
                statement.setInt(1, num);
                rs = statement.executeQuery();
                data = rs.getString(1);
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }
        break;
        default:
        {
            data = "5";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = "5";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* setup the connection */
                conn = IO.getDBConnection();
                /* prepare the query */
                statement = conn.prepareStatement("select name from users where id=?");
                /* get user input for the userid */
                IO.writeLine("Enter a userid to login as (number): ");
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                int num = Integer.parseInt(buffread.readLine());
                statement.setInt(1, num);
                rs = statement.executeQuery();
                data = rs.getString(1);
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* setup the connection */
                conn = IO.getDBConnection();
                /* prepare the query */
                statement = conn.prepareStatement("select name from users where id=?");
                /* get user input for the userid */
                IO.writeLine("Enter a userid to login as (number): ");
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                int num = Integer.parseInt(buffread.readLine());
                statement.setInt(1, num);
                rs = statement.executeQuery();
                data = rs.getString(1);
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = "5";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
        break;
        default:
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* setup the connection */
                conn = IO.getDBConnection();
                /* prepare the query */
                statement = conn.prepareStatement("select name from users where id=?");
                /* get user input for the userid */
                IO.writeLine("Enter a userid to login as (number): ");
                instrread = new InputStreamReader(System.in);
                buffread = new BufferedReader(instrread);
                int num = Integer.parseInt(buffread.readLine());
                statement.setInt(1, num);
                rs = statement.executeQuery();
                data = rs.getString(1);
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = "5";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }
        break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
