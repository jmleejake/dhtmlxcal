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

function gridPageInit() {
	// specify the columns
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

	    }
	    , {headerName: "Price", field: "price", width:200
	    	, editable: true
	    	, cellEditor: 'agTextCellEditor'
	    }
	  ];
	  
	// specify the data
	var rowData = [
		{make: "Toyota", model: "Celica", price: 35000, id:11},
		{make: "Ford", model: "Mondeo", price: 32000, id:22},
		{make: "Porsche", model: "Boxter", price: 72000, id:33}
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
	    onCellEditingStarted: function(event) {
	        previousData = event.node.data.model;
	    },
	    onCellEditingStopped: function(event) {
	        afterData = event.node.data.model;
	        
	        console.log("previous : " + previousData);
	        console.log("after : " + afterData);
	        if (!(previousData == afterData)) {
	        	console.log("modified!");
	        	modifiedData.push({id:event.node.data.id, model:event.node.data.model});
	        }
	    }

	  };
	  
	// lookup the container we want the Grid to use
	  var eGridDiv = document.querySelector('#myGrid');

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
})

$("#btn_mod").on("click", function() {
	if (modifiedData.length == 0) {
		alert("no modified data!");
		return;
	}
	
	console.log("mod in");
	console.log(modifiedData);
	
	var test = [{id:11, model:"111"}, {id:22, model:"11122"}, {id:33, model:"13121"}];
	console.log("test value");
	console.log(test);
	$.ajax({
		url: "update"
		, type:"post"
		, dataType: "json"
		, contentType: 'application/json'
		, data:JSON.stringify(modifiedData)
		, success: function(result){
			var rowData = [];
			for (var i=0; i<result.length; i++) {
				rowData.push({id:result[i].id, make:result[i].make, model:result[i].model, price:result[i].price});
			}
			gridOptions.api.setRowData(rowData);
    	}
	});
});

$("#btn_show").on("click", function() {
	var rowData = [
	  {make: "Toyota", model: "Celica", price: 35000, id:11},
	  {make: "Ford", model: "Mondeo", price: 32000, id:22},
	  {make: "Porsche", model: "Boxter", price: 72000, id:33}
	];
	
	gridOptions.api.setRowData(rowData);
});

$("#btn_create").on("click", function() {
	var rowData = {make:"", modle:"", price:0};
	
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

function getInfo(data) {
	console.log("getInfo");
	console.log(data);
	$('form').attr('action', "getInfo");
	$('form').attr('method', "post");
	$("#car_id").val(data);
	$("form").submit();
}
