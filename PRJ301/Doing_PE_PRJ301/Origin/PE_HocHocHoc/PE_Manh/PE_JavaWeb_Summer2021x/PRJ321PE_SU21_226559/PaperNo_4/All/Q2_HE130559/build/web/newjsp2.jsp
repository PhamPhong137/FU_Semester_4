<%-- 
    Document   : newjsp2
    Created on : Jul 17, 2021, 8:22:19 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <strong>Entry's info</strong>
        <p>EntryID: ${e.getEntryID()} </p>
        <p>EntryTitle: ${e.getTitle()}</p>
        <p>EntryContent: ${e.getContent()} </p>
        <p>Date modified: ${e.getDateModified()}</p>
        <strong>Comment of the entry</strong>
        <table border="1">
            <thead>
                <tr>
                    <th>Comment ID</th>
                    <th>Comment Content</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
