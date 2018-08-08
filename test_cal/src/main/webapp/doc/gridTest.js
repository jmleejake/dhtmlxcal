/**
 * SELECT ADDDATE(now(), -1);
 * csv파일에서 내용을 추출하는 당일과 그 전 날의 데이터를 가져오기위한 
 * 오라클의 add_day였나... 암튼 그런 날짜 관련 함수를 찾아보았다.
 */

// specify the columns
  var columnDefs = [
    {headerName: "Make", field: "make", width:150
    	, editable: true
    	, cellEditor: 'agTextCellEditor'
		, cellEditorParams: {
            maxLength: '300'
		}
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
    , {headerName: "Price", field: "price", width:100
    	, editable: true
    	, cellEditor: 'agTextCellEditor'
		, cellEditorParams: {
            maxLength: '80'
		}
    }
  ];
  
// specify the data
var rowData = [
	{make: "Toyota", model: "Celica", price: 35000, id:11},
	{make: "Ford", model: "Mondeo", price: 32000, id:22},
	{make: "Porsche", model: "Boxter", price: 72000, id:33}
];
//  var rowData = [];
  
  var previousData, afterData;
  var modifiedData = [];
  
  // let the grid know which columns and what data to use
  var gridOptions = {
	  defaultColDef: {
	        width: 100,
	        headerCheckboxSelection: isFirstColumn,
	        checkboxSelection: isFirstColumn
	    },
    enableColResize: true,
    suppressRowClickSelection: false,
    rowSelection: 'multiple',
    columnDefs: columnDefs,
//    onRowSelected: onRowSelected,
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
        	modifiedData.push(event.node.data);
        	console.log(modifiedData);
        }
    }

  };
  
  function isFirstColumn(params) {
	    var displayedColumns = params.columnApi.getAllDisplayedColumns();
	    var thisIsFirstColumn = displayedColumns[0] === params.column;
	    return thisIsFirstColumn;
	}
  
  function onRowSelected(event) {
	  console.log("row selected");
	  console.log(event.node.data);
	}

// lookup the container we want the Grid to use
var eGridDiv = document.querySelector('#myGrid');

// create the grid passing in the div to use together with the columns & data we want to use
new agGrid.Grid(eGridDiv, gridOptions);


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
	
	var data = modifiedData[0];
	console.log("btn mod");
	console.log(data);
	$.ajax({
		url: "update"
		, type:"post"
		, dataType: "json"	
		, data:{id:data.id, make:data.make, model:data.model}
		, success: function(result){
			console.log(result);
			var rowData = [];
			for (var i=0; i<result.length; i++) {
				console.log(result[i]);
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
	
	gridOptions.api.updateRowData({add:[rowData]});
});

function getInfo(data) {
	console.log("getInfo");
	console.log(data);
	$('form').attr('action', "getInfo");
	$('form').attr('method', "post");
	$("#car_id").val(data);
	$("form").submit();
}
