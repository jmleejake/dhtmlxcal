/**
 * SELECT ADDDATE(now(), -1);
 * csv파일에서 내용을 추출하는 당일과 그 전 날의 데이터를 가져오기위한 
 * 오라클의 add_day였나... 암튼 그런 날짜 관련 함수를 찾아보았다.
 * 
 * select STR_TO_DATE("2017/8/7 00:00:00", "%Y/%m/%d %H:%i:%s");
 * 
 * var d = new Date();
 * d.getFullYear() +'/'+ (d.getMonth()+1) + '/' + (d.getDate());
 * 
 * 자바스크립트에서 서버로 보내고 쿼리결과를 아작스로 받아오는게 나을듯싶어
 * 자바스크립트 date활용법을 찾아보았다.
 */

var gridOptions = {};
var previousData, afterData;
var modifiedData = [];

//specify the columns
var columnDefs = [
  {headerName: "Make", field: "make", width:200
  	, editable: true
  	, cellEditor: 'agPopupTextCellEditor'
  }
  , {headerName: "Model", field: "model", width:200
  	, editable: true
      , cellEditor: 'agLargeTextCellEditor'
      , cellEditorParams: {
          maxLength: '500',
          cols: '50',
          rows: '6'
      }
  , tooltip: function(params) { // 길이가 긴 항목에 대해서 툴팁 추가.
  	return params.value;
  }

  }
  , {headerName: "Price", field: "price", width:200
  	, editable: true
  	, cellEditor: 'agTextCellEditor'
  }
];

//lookup the container we want the Grid to use
var eGridDiv = document.querySelector('#myGrid');

function gridPageInit() {
	  
	// specify the data
	var rowData = [
		{make: "Toyota", model: "Celica", price: 35000, id:11, register_date:"2018/08/13"}
		, {make: "Ford", model: "Mondeo", price: 32000, id:22, register_date:"2018/08/14"}
		, {make: "Porsche", model: "Boxter", price: 72000, id:33, register_date:"2018/08/12"}
		, {make:"news", model:"関東甲信、中心に急な激しい雨に注意「同じ災害なのに」豪雨支援金で差ねぶた 駐車代6万500円支払いの人も", price:200, id:44, register_date:"2018/08/13"}
	];
	//  var rowData = [];
	  
	  // let the grid know which columns and what data to use
	  gridOptions = {
		  defaultColDef: {
		        width: 100,
		        headerCheckboxSelection: isFirstColumn,
		        checkboxSelection: isFirstColumn
		    },
	    enableColResize: true,
	    suppressRowClickSelection: false,
	    rowSelection: 'multiple',
	    columnDefs: columnDefs,
//	    onRowSelected: onRowSelected,
	    rowData: rowData,
	    rowClassRules: {
	    	'trans-created': function(params) {
	    		var target = params.data.register_date;
	    		return target === getDate(0);
	    	},
	    	'trans-modified': function(params) {
	    		var target = params.data.update_date;
	    		return target === getDate(0);
	    	}
	    },
	    onCellEditingStarted: function(event) {
	        previousData = event.node.data.model;
	    },
	    onCellEditingStopped: function(event) {
	        afterData = event.node.data.model;
	        
	        console.log("previous : " + previousData);
	        console.log("after : " + afterData);
	        if (!(previousData == afterData)) {
	        	console.log("modified!");
	        	modifiedData.push({
	        		id:event.node.data.id
	        		, model:event.node.data.model
	        		, make:event.node.data.make
	        		, price:event.node.data.price
        		});
	        }
	    }
	    
	  };

	  // create the grid passing in the div to use together with the columns & data we want to use
	  new agGrid.Grid(eGridDiv, gridOptions);
}

  function isFirstColumn(params) {
	    var displayedColumns = params.columnApi.getAllDisplayedColumns();
	    var thisIsFirstColumn = displayedColumns[0] === params.column;
	    return thisIsFirstColumn;
	}
  
  function onRowSelected(event) {
	  console.log("row selected");
	  console.log(event.node.data);
	}


$("#btn_sel").on("click", function() {
	var selectedRows = gridOptions.api.getSelectedRows();
	
	for (var i=0; i<selectedRows.length; i++) {
		var data = selectedRows[i];
		
		console.log(data);
	}
});


$("#btn_del").on("click", function() {
	var selectedRows = gridOptions.api.getSelectedRows();
	var del_seq_id = [];
	
	console.log("del clicked");
	$.each(selectedRows, function(index, selectedRow) {
		del_seq_id.push(selectedRow.id);
	});
	console.log(del_seq_id);
	
	$.ajax({
		url: "delete"
		, type:"post"
		, dataType: "json"
		, contentType: 'application/json'
		, data:JSON.stringify(del_seq_id)
		, success: function(result){
			console.log("success!");
			var rowData = [];
			for (var i=0; i<result.length; i++) {
				rowData.push({
					id:result[i].id
					, make:result[i].make
					, model:result[i].model
					, price:result[i].price
					, register_date:result[i].register_date
					, update_date:result[i].update_date});
			}
			gridOptions.api.setRowData(rowData);
    	}
	});
});

$("#btn_trans").on("click", function() {
	console.log("tranlation");
	var selectedRows = gridOptions.api.getSelectedRows();
	
	if (selectedRows.length == 0) {
		alert("no seleted rows");
		return;
	}
	
	$.ajax({
		url: "returnArrayTest"
		, type:"post"
		, dataType: "json"
		, contentType: 'application/json'
		, data:JSON.stringify(selectedRows)
		, success: function(params){
			console.log(params);
			$("#hid_data").val(params);
			
			$("#frm_test").submit();
    	}
	});
});

$("#btn_mod").on("click", function() {
	if (modifiedData.length == 0) {
		alert("no modified data!");
		return;
	}
	
	$.ajax({
		url: "update"
		, type:"post"
		, dataType: "json"
		, contentType: 'application/json'
		, data:JSON.stringify(modifiedData)
		, success: function(result){
			var rowData = [];
			for (var i=0; i<result.length; i++) {
				rowData.push({
					id:result[i].id
					, make:result[i].make
					, model:result[i].model
					, price:result[i].price
					, register_date:result[i].register_date
					, update_date:result[i].update_date});
			}
			
			 gridOptions.api.setRowData(rowData);
				
			// 수정데이터 초기화
			modifiedData = [];
    	}
	});
});

$("#btn_create").on("click", function() {
	var rowData = {make:"", modle:"", price:0};
	
	// 맨 윗줄에 추가한 row가 보일수있게 세팅
	gridOptions.api.updateRowData({add:[rowData], addIndex:0});
});

$("#txt_keyword").keyup(function(event) {
	console.log(event.keyCode);
	if (event.keyCode == 13) {
		$("#btn_srch").click();
	}
});

$("#btn_srch").on("click", function() {
	console.log("btn_srch clicked!");
	console.log($("#txt_keyword").val());
});
