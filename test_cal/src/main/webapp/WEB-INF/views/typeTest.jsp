<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.1.1.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<script type="text/javascript">
function makeResult(){
	console.log("makeResult()실행");
	
	var firstQ1=$( "input[type=radio][name=FirstQ1]:checked" ).val();
	var firstQ2=$( "input[type=radio][name=FirstQ2]:checked" ).val();
	var firstQ3=$( "input[type=radio][name=FirstQ3]:checked" ).val();
	var firstQ4=$( "input[type=radio][name=FirstQ4]:checked" ).val();
	var firstQ5=$( "input[type=radio][name=FirstQ5]:checked" ).val();
	var firstQtotal = firstQ1*4+firstQ2*4+firstQ3*4+firstQ4*4+firstQ5*4
	console.log("내향/외향 점수 = "+firstQtotal);
	var secondQ1=$( "input[type=radio][name=SecondQ1]:checked" ).val();
	var secondQ2=$( "input[type=radio][name=SecondQ2]:checked" ).val();
	var secondQ3=$( "input[type=radio][name=SecondQ3]:checked" ).val();
	var secondQ4=$( "input[type=radio][name=SecondQ4]:checked" ).val();
	var secondQ5=$( "input[type=radio][name=SecondQ5]:checked" ).val();
	var secondQtotal = secondQ1*4+secondQ2*4+secondQ3*4+secondQ4*4+secondQ5*4
	console.log("청결도 점수 = "+secondQtotal);
	var thirdQ1=$( "input[type=radio][name=ThirdQ1]:checked" ).val();
	var thirdQ2=$( "input[type=radio][name=ThirdQ2]:checked" ).val();
	var thirdQ3=$( "input[type=radio][name=ThirdQ3]:checked" ).val();
	var thirdQ4=$( "input[type=radio][name=ThirdQ4]:checked" ).val();
	var thirdQ5=$( "input[type=radio][name=ThirdQ5]:checked" ).val();
	var thirdQtotal = thirdQ1*4+thirdQ2*4+thirdQ3*4+thirdQ4*4+thirdQ5*4
	console.log("개인/단체 점수 = "+thirdQtotal);
	alert("dd");
}
</script>
</head>
<body>
<form action="#" onsubmit="makeResult()">
<h1>내향/외향</h1>
<table border="1">
<tr>
<th>문제번호</th><th>질문</th><th>매우 그렇다</th><th>그렇다</th><th>보통</th><th>그렇지 않다</th><th>매우 그렇지 않다</th>
</tr>
<tr>
<th>1</th>
<td>낯선 사람과 금방 친해진다</td>
<td>매우 그렇다<input type="radio" name="FirstQ1" value=5 required="required"></td>
<td>그렇다<input type="radio" name="FirstQ1" value=4 required="required"></td>
<td>보통<input type="radio" name="FirstQ1" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="FirstQ1" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="FirstQ1" value=1 required="required"></td>
</tr>
<tr>
<th>2</th>
<td>그룹활동에서 리더가 되는 것을 좋아한다</td>
<td>매우 그렇다<input type="radio" name="FirstQ2" value=5 required="required"></td>
<td>그렇다<input type="radio" name="FirstQ2" value=4 required="required"></td>
<td>보통<input type="radio" name="FirstQ2" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="FirstQ2" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="FirstQ2" value=1 required="required"></td>
</tr>
<tr>
<th>3</th>
<td>여럿이 말하는 것 보다 단 둘이 이야기 하는 것이 편하다</td>
<td>매우 그렇다<input type="radio" name="FirstQ3" value=1 required="required"></td>
<td>그렇다<input type="radio" name="FirstQ3" value=2 required="required"></td>
<td>보통<input type="radio" name="FirstQ3" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="FirstQ3" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="FirstQ3" value=5 required="required"></td>
</tr>
<tr>
<th>4</th>
<td>친구가 많으면 많은 수록 좋다고 생각한다</td>
<td>매우 그렇다<input type="radio" name="FirstQ4" value=1 required="required"></td>
<td>그렇다<input type="radio" name="FirstQ4" value=2 required="required"></td>
<td>보통<input type="radio" name="FirstQ4" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="FirstQ4" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="FirstQ4" value=5 required="required"></td>
</tr>
<tr>
<th>5</th>
<td>조용히 내가 맡은 역할만 하는 것이 좋다</td>
<td>매우 그렇다<input type="radio" name="FirstQ5" value=1 required="required"></td>
<td>그렇다<input type="radio" name="FirstQ5" value=2 required="required"></td>
<td>보통<input type="radio" name="FirstQ5" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="FirstQ5" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="FirstQ5" value=5 required="required"></td>
</tr>
</table>


<h1>청결</h1>
<table border="1">
<tr>
<th>문제번호</th><th>질문</th><th>매우 그렇다</th><th>그렇다</th><th>보통</th><th>그렇지 않다</th><th>매우 그렇지 않다</th>
</tr>
<tr>
<th>1</th>
<td>빨래는 매일 매일 하는 것이 좋다</td>
<td>매우 그렇다<input type="radio" name="SecondQ1" value=5 required="required"></td>
<td>그렇다<input type="radio" name="SecondQ1"  value=4 required="required"></td>
<td>보통<input type="radio" name="SecondQ1"  value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="SecondQ1" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="SecondQ1" value=1 required="required"></td>
</tr>
<tr>
<th>2</th>
<td>방청소는 원래 한달에 한번 하는 것이다</td>
<td>매우 그렇다<input type="radio" name="SecondQ2" value=1 required="required"></td>
<td>그렇다<input type="radio" name="SecondQ2" value=2 required="required"></td>
<td>보통<input type="radio" name="SecondQ2" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="SecondQ2" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="SecondQ2" value=5 required="required"></td>
</tr>
<tr>
<th>3</th>
<td>설거지는 먹는 즉시 그때 그때 한다</td>
<td>매우 그렇다<input type="radio" name="SecondQ3" value=5 required="required"></td>
<td>그렇다<input type="radio" name="SecondQ3" value=4 required="required"></td>
<td>보통<input type="radio" name="SecondQ3" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="SecondQ3" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="SecondQ3" value=1 required="required"></td>
</tr>
<tr>
<th>4</th>
<td>사용한 것은 바로바로 제자리에 둔다</td>
<td>매우 그렇다<input type="radio" name="SecondQ4" value=5 required="required"></td>
<td>그렇다<input type="radio" name="SecondQ4" value=3 required="required"></td>
<td>보통<input type="radio" name="SecondQ4" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="SecondQ4" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="SecondQ4" value=1 required="required"></td>
</tr>
<tr>
<th>5</th>
<td>샤워는 매일매일 목욕은 일주일에 1번해야한다</td>
<td>매우 그렇다<input type="radio" name="SecondQ5" value=5 required="required"></td>
<td>그렇다<input type="radio" name="SecondQ5" value=4 required="required"></td>
<td>보통<input type="radio" name="SecondQ5" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="SecondQ5" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="SecondQ5" value=1 required="required"></td>
</tr>
</table>


<h1>개인/단체</h1>

<table border="1">
<tr>
<th>문제번호</th><th>질문</th><th>매우 그렇다</th><th>그렇다</th><th>보통</th><th>그렇지 않다</th><th>매우 그렇지 않다</th>
</tr>
<tr>
<th>1</th>
<td>남이 내물건에 만지는 것이 싫다</td>
<td>매우 그렇다<input type="radio" name="ThirdQ1" value=1 required="required"></td>
<td>그렇다<input type="radio" name="ThirdQ1"  value=2 required="required"></td>
<td>보통<input type="radio" name="ThirdQ1"  value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="ThirdQ1" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="ThirdQ1" value=5 required="required"></td>
</tr>
<tr>
<th>2</th>
<td>음식을 먹어도 다 함께 먹는 것이 좋다</td>
<td>매우 그렇다<input type="radio" name="ThirdQ2" value=5 required="required"></td>
<td>그렇다<input type="radio" name="ThirdQ2" value=4 required="required"></td>
<td>보통<input type="radio" name="ThirdQ2" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="ThirdQ2" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="ThirdQ2" value=1 required="required"></td>
</tr>
<tr>
<th>3</th>
<td>주말엔 혼자 여유롭게 있고 싶다</td>
<td>매우 그렇다<input type="radio" name="ThirdQ3" value=1 required="required"></td>
<td>그렇다<input type="radio" name="ThirdQ3" value=2 required="required"></td>
<td>보통<input type="radio" name="ThirdQ3" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="ThirdQ3" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="ThirdQ3" value=5 required="required"></td>
</tr>
<tr>
<th>4</th>
<td>파티는 사람이 많으면 많을수록 좋다</td>
<td>매우 그렇다<input type="radio" name="ThirdQ4" value=5 required="required"></td>
<td>그렇다<input type="radio" name="ThirdQ4" value=3 required="required"></td>
<td>보통<input type="radio" name="ThirdQ4" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="ThirdQ4" value=2 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="ThirdQ4" value=1 required="required"></td>
</tr>
<tr>
<th>5</th>
<td>조용한 분위기가 좋다</td>
<td>매우 그렇다<input type="radio" name="ThirdQ5" value=1 required="required"></td>
<td>그렇다<input type="radio" name="ThirdQ5" value=2 required="required"></td>
<td>보통<input type="radio" name="ThirdQ5" value=3 required="required"></td>
<td>그렇지 않다<input type="radio" name="ThirdQ5" value=4 required="required"></td>
<td>매우 그렇지 않다<input type="radio" name="ThirdQ5" value=5 required="required"></td>
</tr>
</table>



<input type="submit">
</form>

</body>
</html>