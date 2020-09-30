
<%@page import="com.dts.project.dao.SellItemDAO"%><%
String name[]=request.getParameterValues("itemname");
boolean flag=false;
for(int i=0;i<name.length;i++)
{
 flag=new SellItemDAO().deleteItems(name[i]);
}

RequestDispatcher rd=request.getRequestDispatcher("viewItemAction.do");
rd.forward(request,response);
%>