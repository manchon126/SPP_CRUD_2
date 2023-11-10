//crud.js

function listPage(){
	listUrl = "/posts";
	
	let table = document.createElement('table');
	let thead = document.createElement('thead');
	let tbody = document.createElement('tbody');
	
	table.appendChild(thead);
	table.appendChild(tbody);

	// Adding the entire table to the body tag
	document.getElementById('tableBoardlist').appendChild(table);
	
	// Creating and adding data to first row of the table
	let row_1 = document.createElement('tr');
	let heading_1 = document.createElement('th');
	heading_1.innerHTML = "abc";
	let heading_2 = document.createElement('th');
	heading_2.innerHTML = "제목";
	let heading_3 = document.createElement('th');
	heading_3.innerHTML = "작성자";
	let heading_4 = document.createElement('th');
	heading_4.innerHTML = "작성일";
	let heading_5 = document.createElement('th');
	heading_5.innerHTML = "조회수";
	
	row_1.appendChild(heading_1);
	row_1.appendChild(heading_2);
	row_1.appendChild(heading_3);
	row_1.appendChild(heading_4);
	row_1.appendChild(heading_5);
	thead.appendChild(row_1);
	
	sendAjax(listUrl, (isSuccess, res)=>{
		if(isSuccess){
			let data = res.list;
			let str = "";
            
			/*
			    $(data).each(function(d){
			    str += ...
			    }); 와 같음
			*/
			data.forEach(
			    (d) => {
				// Creating and adding board DB data to n-th row of the table
				let row_n = document.createElement('tr');
				let row_n_data_1 = document.createElement('td');
				row_n_data_1.innerHTML = d.bno;
				let row_n_data_2 = document.createElement('td');
				row_n_data_2.innerHTML = "<a href='/read?bno="+d.bno+"'>"+ d.title +"</a>" ;
				let row_n_data_3 = document.createElement('td');
				row_n_data_3.innerHTML = d.writer;
				let row_n_data_4 = document.createElement('td');
				var dateFormatted = new Date(d.regdate).toLocaleString("ko-KR");
				row_n_data_4.innerHTML = dateFormatted;
				let row_n_data_5 = document.createElement('td');
				row_n_data_5.innerHTML = d.viewcnt;
				
				row_n.appendChild(row_n_data_1);
				row_n.appendChild(row_n_data_2);
				row_n.appendChild(row_n_data_3);
				row_n.appendChild(row_n_data_4);
				row_n.appendChild(row_n_data_5);
				tbody.appendChild(row_n);
			    }
			);
			
		}
	});
}

function sendAjax(url, fn,  method, jsonData){
	let options = {
			method: method || 'GET',
			url: url,
			contentType: "application/json"
	};
	//jsonData가 있을 때만 data : JSON.stringify(jsonData) 추가
	if(jsonData){
		options.data = JSON.stringify(jsonData);
	}
	
	$.ajax(options).always((responseText, statusText, ajaxResult) =>{
		let isSuccess = statusText === 'success'; //ajax 호출 성공 여부
		fn(isSuccess, responseText);
		if(!isSuccess){
			alert("오류가 발생하였습니다. (errorMessage:" + responseText + ")");
		}
	})
}

function readWriting(bno) {
	let listUrl = "/posts/" + bno;	
	
	sendAjax(listUrl, (isSuccess, res)=>{
		if(isSuccess){
			let data = res.boardDTO;
			let str = "";          

			document.getElementsByName("bno")[0].value = data.bno;
			document.getElementsByName("title")[0].value = data.title;
			document.getElementsByName("writer")[0].value = data.writer;
			document.getElementsByName("content")[0].value = data.content;
		}
	});
}

function registerWriting(){
	const REGIST_URL = "/posts";
	let $title = $('#title'), 
	$writer = $('#writer'), 
	$content = $('#content');
	let jsonData = getValidData($title, $writer, $content);
	if(!jsonData){
		return;
	}
	
	sendAjax(REGIST_URL, (isSuccess, res) => {
		if(isSuccess){
			alert("등록이 완료 되었습니다.");
			location.href='/test';
		}else{
			console.debug("Error on registerReply>>",res);
		}
	} , 'POST', jsonData);
}

function getValidData($title, $writer, $content){
	let errorFocus = null,
	title = $title.val(),
	writer = $writer.val(),
	content = $content.val(),
	errorMsg = "";
	
	if(!title){
		errorMsg = "글 제목을 입력하세요.";
		$errorFocus = $title;
	} else if(!writer){
		errorMsg = "작성자를 입력하세요.";
		$errorFocus = $writer;
	} else if(!content){
		errorMsg = "내용을 입력하세요";
		$errorFocus = $content;
	}
	
	if(errorMsg){
		alert(errorMsg);
		$errorFocus.focus();
		return;
	}
	
	return {title: title, writer: writer, content: content};
}

function updateWriting(){
	let REGIST_URL = "/posts";
	let $bno = $('#bno'),
	$title = $('#title'), 
	$writer = $('#writer'), 
	$content = $('#content');	
	let bno_ = $bno.val();
	
	REGIST_URL += "/"+$bno.val();
	let jsonData = getValidUpdateData($bno, $title, $writer, $content);
	if(!jsonData){
		return false;
	}
	
	sendAjax(REGIST_URL, (isSuccess, res) => {
		if(isSuccess){
			alert("등록이 완료 되었습니다.");
			location.href='/read?bno='+bno_;
		}else{
			console.debug("Error on registerReply>>",res);
		}
	} , 'PUT', jsonData);
	return true;
}

function getValidUpdateData($bno, $title, $writer, $content){
	let errorFocus = null,
	bno = $bno.val(),
	title = $title.val(),
	writer = $writer.val(),
	content = $content.val(),
	errorMsg = "";
	
	if(!bno){
		errorMsg = "글 번호가 누락되었습니다.";
		$errorFocus = $bno;
	} else if(!title){
		errorMsg = "글 제목을 입력하세요.";
		$errorFocus = $title;
	} else if(!writer){
		errorMsg = "작성자를 입력하세요.";
		$errorFocus = $writer;
	} else if(!content){
		errorMsg = "내용을 입력하세요";
		$errorFocus = $content;
	}
	
	if(errorMsg){
		alert(errorMsg);
		$errorFocus.focus();
		return;
	}
	
	return {bno: bno, title: title, writer: writer, content: content};
}

function removeWriting(bno) {
	if(!confirm("정말 삭제하겠습니까?")) return;
	
	sendAjax("/posts/"+bno, (isSuccess, res) => {
		if(isSuccess){
			alert(bno+"번 글이 삭제완료되었습니다.");
			location.href='/test';
		} else{
			alert("삭제 오류 발생");
			console.debug("Error on removeReply>>",res);
		}
	}, 'DELETE');
}

function fillForm(bno, title, writer, content) {
	let $bno = $('#bno'),
	$title = $('#title'), 
	$writer = $('#writer'), 
	$content = $('#content');
	
	$bno.val(bno);
	$title.val(title);
	$writer.val(writer);
	$content.val(content);
}

function readWritingForModify(bno) {
	let listUrl = "/posts/" + bno;	
	
	sendAjax(listUrl, (isSuccess, res)=>{
		if(isSuccess){
			let data = res.boardDTO; 
			
			let $bno = $('#bno'),
			$title = $('#title'), 
			$writer = $('#writer'), 
			$content = $('#content');
			
			$bno.val(data.bno);
			$title.val(data.title);
			$writer.val(data.writer);
			$content.val(data.content);
		}
	});
}