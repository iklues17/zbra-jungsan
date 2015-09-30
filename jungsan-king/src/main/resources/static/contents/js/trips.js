		
page.Trips = (function(){
	
	var ENV = {
		EXP_ITEM_DIV_ID: "#divExpItem",
		EXP_ITEM_GRID_ID: "#gridExpItem",
		ADD_EXP_ITEM_BTN: "#btnAddExpItem",
		MOD_EXP_ITEM_BTN: "#btnModExpItem"
	};
	
	var tripsView = {
		init : function(){
			
		}
	};
	
	var tripDetailView = {
		init : function(tripId){
			
		}
	}
	
	var expensesItemView = {
		init : function(tripId){
			_that = this;
            $(ENV.EXP_ITEM_GRID_ID+" tbody>tr").on('mouseover', function(e){
            	$(e.currentTarget).addClass('recode-active');
            });
		    $(ENV.EXP_ITEM_GRID_ID+" tbody>tr").on('mouseout', function(e){
		    	$(e.currentTarget).removeClass('recode-active');
		    });
		    $("tbody>tr").on('click', function(e){
            	$(e.currentTarget).addClass('recode-selected');
		    });
		    
		    $(ENV.MOD_EXP_ITEM_BTN).on('click', function(e){
		    	var datas = [$(ENV.EXP_ITEM_GRID_ID).find('.recode-selected').attr('id')];
		    	var tds = $("#divExpItem").find('.recode-selected > td');
		    	$.each(tds, function(i){
		    		datas.push($(this).text());
		    	});
		    	comm.openModalForEntry(comm.getHtml("contents/expenses-item-form.html"), datas, _that.callbackModModal);
		    });
		    $(ENV.ADD_EXP_ITEM_BTN).on('click', function(e){
		    	comm.openModalForEntry(comm.getHtml("contents/expenses-item-form.html"), null, _that.callbackAddModal);
		    });
		},
		
		callbackModModal: function(datas){
			comm.closeModal();
		},
		
		callbackAddModal: function(datas){
			
		},
		
		getItems: function(tripId){
			var data = [{
				itemId: "test",
				itemName: "test",
				cost: "15000"
			}];
			return data;
		}
	}
	
	return {
		initPage : function(){

			if(!comm.initPage()){
		    	return;
		    }
			
			page.Trips.initDetailPage("na");
	
//		    template.RenderOne({
//		        target: "#body",
//		        tagName: "div",
//		        className: "trips",
//		        id: "bodyTrips",
//		        position: "new",
//		        template: comm.getHtml("trips.html"),
//		        data: {},
//		        events: {
//		        },
//	
//		        afterRender: function() { 
//		        	tripsView.init();
//		        }
//		    });
		   
		},
		
		initDetailPage: function(tripId){

			if(!comm.initPage()){
		    	return;
		    }
	
		    template.RenderOne({
		        target: "#body",
		        tagName: "div",
		        className: "trip-detail",
		        id: "bodyTripDetail",
		        position: "new",
		        template: comm.getHtml("contents/trip-detail.html"),
		        data: {},
		        events: {
		        },
	
		        afterRender: function() { 
		        	tripDetailView.init(tripId);
		        }
		    });
	
		    var items = expensesItemView.getItems();
		    var itemGrid = {
				tableheaders : [
	                {display:'Item Name',		hidden:false, width: '50%'},
	                {display:'Cost',			hidden:false, width: '50%'}
                ],
                tabledatas: items,
                link: "*.html"
    		};
		    
		    template.RenderOne({
		        target: "#divExpItem",
		        tagName: "div",
		        className: "trip-detail-items",
		        id: "bodyTripDetailItems",
		        position: "new",
		        template: comm.getHtml("contents/sub-expenses-items.html"),
		        data: itemGrid,
		        events: {
		        },
	
		        afterRender: function() { 
		        	expensesItemView.init(tripId);
		        }
		    });
		}
	};
})();