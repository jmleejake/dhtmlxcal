
//specify the columns
var columnDefs = [
  {headerName: "Make", field: "make", width:200}
  , {headerName: "Model", field: "model", width:200
	  , tooltip: function(params) { // 길이가 긴 항목에 대해서 툴팁 추가.
	  	return params.value;
	  }
  }
  , {headerName: "Price", field: "price", width:200}
];

//lookup the container we want the Grid to use
var eGridDiv = document.querySelector('#myGrid');

var rowData = [];
	  
  // let the grid know which columns and what data to use
  gridOptions = {
//		  defaultColDef: {
//		        width: 100,
//		        headerCheckboxSelection: isFirstColumn,
//		        checkboxSelection: isFirstColumn
//		    },
    enableColResize: true,
    suppressRowClickSelection: false,
    rowSelection: 'multiple',
    columnDefs: columnDefs,
//	    onRowSelected: onRowSelected,
    rowData: rowData,
  };

  // create the grid passing in the div to use together with the columns & data we want to use
  new agGrid.Grid(eGridDiv, gridOptions);
  
  function getData() {
	$.ajax({
		url: "transResult"
		, type:"post"
		, data:{id_lst:$("#seq_id_list").val()}
		, success: function(result){
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
  }
  
  $("#btn_down").on("click", function() {
	  /**
	   * 선두컬럼 체크박스가 필요하다가 요구하지 않는이상
	   * 화면전환시 넘겨주었던 seq_id 리스트를 가지고 서버사이드로 넘겨
	   * 쿼리한 결과를 다운로드 처리하면 될듯
	   * */
	  console.log($("#seq_id_list").val());
  });
