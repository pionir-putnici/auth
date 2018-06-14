//    // Edit record
//    $('#magaciniTable').on('click', 'a.editor_edit', function (e) {
//    	
//        var data = table.row( $(this).parents('tr') ).data();
//        alert( data[0] +"'s salary is: "+ data[ 5 ] );
//        
//        e.preventDefault();
// 
//        editor.edit( $(this).closest('tr'), {
//            title: 'Edit record',
//            buttons: 'Update'
//        } );
//    } );
// 
//    // Delete a record
//    $('#magaciniTable').on('click', 'a.editor_remove', function (e) {
//        e.preventDefault();
// 
//        editor.remove( $(this).closest('tr'), {
//            title: 'Delete record',
//            message: 'Are you sure you wish to remove this record?',
//            buttons: 'Delete'
//        } );
//    } );
//    

//$(document).ready(function() {
//    var table = $('#example').DataTable( {
//        "ajax": "data/arrays.txt",
//        "columnDefs": [ {
//            "targets": -1,
//            "data": null,
//            "defaultContent": "<button>Click!</button>"
//        } ]
//    } );
// 
//    $('#example tbody').on( 'click', 'button', function () {
//        var data = table.row( $(this).parents('tr') ).data();
//        alert( data[0] +"'s salary is: "+ data[ 5 ] );
//    } );
//} );
 


//    $('#magaciniTable tbody').on( 'click', 'button', function () {
//        var data = table.row( $(this).parents('tr') ).data();
//        alert( data[0] +"'s salary is: "+ data[3] );
//    } );
//    
//$(document).ready( function () {
//	 var table = $('#magaciniTable').DataTable({
//			"sAjaxSource": "/magacini",
//			"sAjaxDataProp": "",
//			"order": [[ 0, "asc" ]],
//			"aoColumns": [
//			      { "mData": "0"},
//		          { "mData": "1" },
//				  { "mData": "2" },
//				  { "mData": "3" },
//				  { "mData": "4"},
//				  { "mData": "5" },
////				  { "mData": "6"},
//				  {
//					  
//		                data: null,
//		                className: "center",
//		                defaultContent: "<button>Click!</button>"
//		            }
//			]
//	 
//	 })	 
//});


$(document).ready( function () {
	 var table = $('#magaciniTable').DataTable({
			"sAjaxSource": "/magacini",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "code" },
				  { "mData": "name" },
				  { "mData": "slika" },				  
				  { "mData": "adresa" },
				  { "mData": "zvuk" },
				  { "mData": "vrste_magacina_naziv"},
				  { "mData": "aktivan" },
				  { "mData": "akcija"}
			]
	 })	 
});

//{ "mData": "id"},
//{ "mData": "code" },
//{ "mData": "name" },
//{ "mData": "remark" },
//{ "mData": "name"},
//{ "mData": "aktivan" },
//{ "mData": "akcija"}

//var editor; // use a global for the submit and return data rendering in the examples
//
//$(document).ready(function() {
//    editor = new $.fn.dataTable.Editor( {
//        ajax: "/vrstepaleta",
//        table: "#vrstePaletaTable",
//        fields: [ {
//                label: "Uid:",
//                name: "uid"
//            }, {
//                label: "Code:",
//                name: "code"
//            }, {
//                label: "Name:",
//                name: "name"
//            }, {
//                label: "Remark:", 
//                name: "remark"
//            }, {
//                label: "Timestampa:",
//                name: "timestamp",
//                type: "datetime"
//            }, {
//                label: "Aktivan:",
//                name: "aktivan"
//            }
//            
//        ]
//    } );
// 
//    $('#vrstePaletaTable').DataTable( {
//        dom: "Bfrtip",
//        ajax: "/vrstepaleta",
//        columns: [
//            { data: null, render: function ( data, type, row ) {
//                // Combine the first and last names into a single table field
//                return data.first_name+' '+data.last_name;
//            } },
//            { data: "id" },
//            { data: "code" },
//            { data: "name" },
//            { data: "timestamp" },
//            { data: "aktivan" }
//        ],
//        select: true,
//        buttons: [
//            { extend: "create", editor: editor },
//            { extend: "edit",   editor: editor },
//            { extend: "remove", editor: editor }
//        ]
//    } );
//} );



//$(document).ready( function () {
//	 var table = $('#vrstePaletaTable').DataTable({
//			"sAjaxSource": "/vrstepaleta",
//			"sAjaxDataProp": "",
//			"order": [[ 0, "asc" ]],
//			"aoColumns": [
//			      { "mData": "uid"},
//		          { "mData": "code" },
//				  { "mData": "name" },
//				  { "mData": "remark" },
//				  { "mData": "timestamp"},
//				  { "mData": "aktivan" },
//				  { "mData": "akcija"}
//    ]
//	 ,
//    select: true,
//    buttons: [
//        { extend: 'create', editor: editor },
//        { extend: 'edit',   editor: editor },
//        { extend: 'remove', editor: editor }
//    ]
//} );

//$(document).ready(function() {
//    editor = new $.fn.dataTable.Editor( {
//        ajax: '../php/dates.php?format=custom',
//        table: '#example',
//        fields: [ {
//                label: 'First name:',
//                name:  'first_name'
//            }, {
//                label: 'Last name:',
//                name:  'last_name'
//            }, {
//                label:  'Updated date:',
//                name:   'updated_date',
//                type:   'datetime',
//                def:    function () { return new Date(); },
//                format: 'LLL',
//                fieldInfo: 'US style m/d/y format'
//            }, {
//                label:  'Registered date:',
//                name:   'registered_date',
//                type:   'datetime',
//                def:    function () { return new Date(); },
//                format: 'dddd D MMMM YYYY',
//                fieldInfo: 'Verbose date format'
//            }
//        ]
//    } );