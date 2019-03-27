<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="assets/css/page/hotel.css">
 
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    var dateFormat = "mm/dd/yy",
      from = $( "#from" )
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
          numberOfMonths: 3
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#to" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 3
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
 });
  </script>
 
<meta charset="UTF-8">
 

<title>Pet hotel</title>
</head>
<body>
	<nav>상단의 네비게이션바 들어올 예정</nav>

	<div class="total-div">
			<div class="left-div">
			
				<div class="address-mm">
				주소부분
				</div>
				<br/>
				<br/>
				<br/>
				<div class="test">
					<div id="cal1" class="to1">
					<label for="from">체크인</label>
					<input type="text" id="from" name="from">
					</div>
					
					<div id="empty" class="to1">
						
						
					</div>
					
					<div id="cal2" class="to1">
					<label for="to">체크아웃</label>
					<input type="text" id="to" name="to">
					</div>
				</div>
				
			</div>
			
			<div class="right-div">
			
				<div class="top-bar">
					<div class="move1">
						(Total업체 갯수 가 들어옴)
					</div>
				 
					 <div class="move2">
					 <input type="radio" id="topic" class="set" name="1">인기순
					 <input type="radio" id="distance" class="set" name="1">거리순
					 <input type="radio" id="avg" class="set" name="1">평점순
					 </div>
				</div>
				<div class="list-bar">
					<div></div>
				</div>
				
			</div>

	</div>

	<footer>하단의 내용이 들어올 곳</footer>
</body>
</html>