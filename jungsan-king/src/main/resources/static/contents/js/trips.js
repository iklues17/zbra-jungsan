		
page.Trips = (function(){
	
	var ENV = {
		EXP_ITEM_DIV_ID: "#divExpItem",
		EXP_ITEM_GRID_ID: "#gridExpItem",
		ADD_EXP_ITEM_BTN: "#btnAddExpItem",
		MOD_EXP_ITEM_BTN: "#btnModExpItem",
		DEL_EXP_ITEM_BTN: "#btnDelExpItem",
		
		MEMBER_DIV_ID: "#divMembers",
		MEMBER_GRID_ID: "#gridMembers",
		ADD_MEMBER_BTN: "#btnAddMember",
		MOD_MEMBER_BTN: "#btnModMember",
		DEL_MEMBER_BTN: "#btnDelMember",
		
		CURR_SEL_ITEM_ID: "",
		CURR_SEL_MEMBER_ID: "",
	};
	
	var tripsView = {
		init : function(){
			
		}
	};
	
	var tripDetailView = {
		init : function(tripId){
			
		}
	};
	
	var membersView = {
		init : function(tripId){
			_that = this;
            $(ENV.MEMBER_GRID_ID+" tbody>tr").on('mouseover', function(e){
            	$(e.currentTarget).addClass('recode-active');
            });
		    $(ENV.MEMBER_GRID_ID+" tbody>tr").on('mouseout', function(e){
		    	$(e.currentTarget).removeClass('recode-active');
		    });
		    $("tbody>tr").on('click', function(e){
            	$(ENV.MEMBER_GRID_ID+" tbody>tr").removeClass('recode-selected');
            	$(e.currentTarget).addClass('recode-selected');
		    });
		    
		    $(ENV.MOD_MEMBER_BTN).on('click', function(e){
		    	var datas = [$(ENV.MEMBER_GRID_ID).find('.recode-selected').attr('id')];
		    	var tds = $(ENV.MEMBER_DIV_ID).find('.recode-selected > td');
		    	$.each(tds, function(i){
		    		datas.push($(this).text());
		    	});
		    	comm.openModalForEntry("MOD", comm.getHtml("contents/member-form.html"), datas, _that.callbackModModal);
		    });
		    $(ENV.ADD_MEMBER_BTN).on('click', function(e){
		    	comm.openModalForEntry("ADD", comm.getHtml("contents/member-form.html"), null, _that.callbackAddModal);
		    });
		    $(ENV.DEL_MEMBER_BTN).on('click', function(e){
		    	$(ENV.MEMBER_GRID_ID+' tbody>tr.recode-selected').remove();
		    });
		    
		    comm.installGrid($(ENV.MEMBER_GRID_ID));
		},
		
		callbackModModal: function(datas){
			var currRow = $(ENV.MEMBER_GRID_ID+' tbody>tr.recode-selected');
			$(currRow).find('td:eq(0)').text(datas.memberName);
			$(currRow).find('td:eq(1)').text(datas.payment);
			comm.closeModal();
		},
		
		callbackAddModal: function(datas){
			$(ENV.MEMBER_GRID_ID+' tbody').append('<tr><td></td><td></td></tr>');
			var newRow = $(ENV.MEMBER_GRID_ID+' tbody').find('tr:last()');
			$(newRow).find('td:eq(0)').text(datas.memberName);
			$(newRow).find('td:eq(1)').text(datas.payment);
			comm.closeModal();
		},
		
		getMembers: function(tripId){
			// TODO call rest api /trips/{tripId}/members
			var data = {
				totalPayment: 999900,	
				members: [{
					memberId: "1",
					memberName: "슬기",
					payment: "846900"
				},{
					memberId: "2",
					memberName: "원기",
					payment: "0"
				},{
					memberId: "3",
					memberName: "광록",
					payment: "0"
				},{
					memberId: "4",
					memberName: "정섭",
					payment: "53000"
				},{
					memberId: "5",
					memberName: "은경",
					payment: "0"
				},{
					memberId: "6",
					memberName: "재관",
					payment: "100000"
				},{
					memberId: "7",
					memberName: "현수",
					payment: "0"
				},{
					memberId: "8",
					memberName: "경주",
					payment: "0"
				}]
			};
			return data;
		},
		
		getDatas : function(){
			var members = [];
			var trs = $(ENV.MEMBER_GRID_ID+' [data-obj="member"]');
			$.each(trs, function(idx){
				members.push({
					memberId:$(this).attr('id'),
					memberName: $(this).find('[data-obj="memberName"]').text(),
					payment: $(this).find('[data-obj="payment"]').text()
				});
			});
			return {
				crew: {},
				members: members,
				total: $('[data-obj="membersTot"]').text()
			};
		}
	};
	
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
            	$(ENV.EXP_ITEM_GRID_ID+" tbody>tr").removeClass('recode-selected');
            	$(e.currentTarget).addClass('recode-selected');
		    });
		    
		    $(ENV.MOD_EXP_ITEM_BTN).on('click', function(e){
		    	var datas = [$(ENV.EXP_ITEM_GRID_ID).find('.recode-selected').attr('id')];
		    	var tds = $(ENV.EXP_ITEM_DIV_ID).find('.recode-selected > td');
		    	$.each(tds, function(i){
		    		datas.push($(this).text());
		    	});
		    	comm.openModalForEntry("MOD", comm.getHtml("contents/expenses-item-form.html"), datas, _that.callbackModModal);
		    });
		    $(ENV.ADD_EXP_ITEM_BTN).on('click', function(e){
		    	comm.openModalForEntry("ADD", comm.getHtml("contents/expenses-item-form.html"), null, _that.callbackAddModal);
		    });
		    $(ENV.DEL_EXP_ITEM_BTN).on('click', function(e){
		    	$(ENV.EXP_ITEM_GRID_ID+' tbody>tr.recode-selected').remove();
		    });
		    
		    comm.installGrid($(ENV.EXP_ITEM_GRID_ID));
		},
		
		callbackModModal: function(datas){
			var currRow = $(ENV.MEMBER_GRID_ID+' tbody>tr.recode-selected');
			$(currRow).find('td:eq(0)').text(datas.itemName);
			$(currRow).find('td:eq(1)').text(datas.cost);
			comm.closeModal();
		},
		
		callbackAddModal: function(datas){
			$(ENV.MEMBER_GRID_ID+' tbody').append('<tr><td></td><td></td><td></td></tr>');
			var newRow = $(ENV.EXP_ITEM_GRID_ID+' tbody').find('tr:last()');
			$(newRow).find('td:eq(0)').text(datas.itemName);
			$(newRow).find('td:eq(1)').text(datas.cost);
			comm.closeModal();
		},
		
		getItems: function(tripId){
			// TODO call rest api /trips/{tripId}/items
			var data = {
				totalCost: 999900,	
				items: [{
					itemId: "1",
					itemName: "일)대여",
					cost: "90000" // 보드2, 수트3 - 은경 수트(1) / 원기 수트(1) / 정섭 보드수트(4) / 광록 보드(3)
				},{
					itemId: "2",
					itemName: "일)저녁",
					cost: "71000"
				},{
					itemId: "3",
					itemName: "일)닭강정",
					cost: "18000"
				},{
					itemId: "4",
					itemName: "일)술",
					cost: "25200"
				},{
					itemId: "5",
					itemName: "월)아침",
					cost: "4000"
				},{
					itemId: "6",
					itemName: "월)슈퍼",
					cost: "3000"
				},{
					itemId: "7",
					itemName: "월)커피",
					cost: "14000"
				},{
					itemId: "8",
					itemName: "월)점심",
					cost: "34000"
				},{
					itemId: "9",
					itemName: "월)저녁",
					cost: "96000"
				},{
					itemId: "10",
					itemName: "월)술1",
					cost: "30700"
				},{
					itemId: "11",
					itemName: "월)술2",
					cost: "9800"
				},{
					itemId: "12",
					itemName: "월)술3",
					cost: "3900"
				},{
					itemId: "13",
					itemName: "월)술4",
					cost: "18800"
				},{
					itemId: "14",
					itemName: "월)술5",
					cost: "7500"
				},{
					itemId: "15",
					itemName: "화)아침",
					cost: "7500"
				},{
					itemId: "16",
					itemName: "화)커피",
					cost: "15000" //슬기,광록,정섭 
				},{
					itemId: "17",
					itemName: "화)대여",
					cost: "145000" // 경주 보드(3.5) / 현수 보드(3.5) / 광록 보드(3.5) / 정섭 보드수트(4)
				},{
					itemId: "18",
					itemName: "화)점심",
					cost: "30000"
				},{
					itemId: "19",
					itemName: "화)아스크림",
					cost: "3500"
				},{
					itemId: "20",
					itemName: "화)저녁",
					cost: "53000"
				},{
					itemId: "21",
					itemName: "유류비",
					cost: "200000" // 슬기, 재관, 원기(.5), 정섭, 은경, 광록 
				},{
					itemId: "22",
					itemName: "일)숙박",
					cost: "60000" // 슬기, 원기, 정섭, 은경, 광록 
				},{
					itemId: "23",
					itemName: "월)숙박",
					cost: "60000" // 슬기, 재관, 정섭, 은경, 광록 
				}]
			};
			return data;
		},
		
		getDatas : function(){
			var items = [];
			var trs = $(ENV.EXP_ITEM_GRID_ID+' [data-obj="item"]');
			$.each(trs, function(idx){
				items.push({
					itemId:$(this).attr('id'),
					itemName: $(this).find('[data-obj="itemName"]').text(),
					cost: $(this).find('[data-obj="cost"]').text()
				});
			});
			return {
				crew: {},
				items: items,
				total: $('[data-obj="expItemsTot"]').text()
			};
		}
	}
	
	return {
		initPage : function(){

			if(!comm.initPage()){
		    	return;
		    }
			
			window.location.hash = "#trips/20150927";
		   
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
	                {display:'Item Name',	hidden:false, width: '50%'},
	                {display:'Cost',		hidden:false, width: '50%'}
                ],
                tabledatas: items.items,
                totalCost: comm.addComma(items.totalCost)
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
	
		    var members = membersView.getMembers();
		    var memberGrid = {
				tableheaders : [
	                {display:'Name',		hidden:false, width: '50%'},
	                {display:'Payment',		hidden:false, width: '50%'}
                ],
                tabledatas: members.members,
                totalPayment: comm.addComma(members.totalPayment)
    		};
		    
		    template.RenderOne({
		        target: "#divMembers",
		        tagName: "div",
		        className: "trip-detail-members",
		        id: "bodyTripDetailMembers",
		        position: "new",
		        template: comm.getHtml("contents/sub-members.html"),
		        data: memberGrid,
		        events: {
		        },
	
		        afterRender: function() { 
		        	membersView.init(tripId);
		        }
		    });

		    template.RenderOne({
		        target: "#divMetrix",
		        tagName: "div",
		        className: "trip-detail-metrix",
		        id: "bodyTripDetailMetrix",
		        position: "new",
		        template: comm.getHtml("contents/sub-metrix.html"),
		        data: {},
		        events: {
		        },
	
		        afterRender: function() {
		        	JsKingMetrix.init();
				    JsKingMetrix.viewMetrix(tripId);
				    
				    $("#btnMakeMatrix").on('click', function(){
				    	JsKingMetrix.makeNewMetrix(expensesItemView.getDatas(), membersView.getDatas());
				    });
				    
		        }
		    });
		}
	};
})();