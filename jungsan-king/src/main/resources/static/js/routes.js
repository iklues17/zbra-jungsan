$(function(){

    var AppRouter = new (Backbone.Router.extend({
        routes: {
        	""				: page.Trips.initPage,
        	"trips"			: page.Trips.initPage,
        	"trips/:tripId"	: page.Trips.initDetailPage
            
        },

    }));

    Backbone.history.start();

});