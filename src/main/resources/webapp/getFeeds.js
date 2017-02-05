function getFeeds(accessTocken, linkedInName, linkedInPass) {
$.ajax({
    url: '/feeds?accessToken='+accessTocken+'&linkedName='+linkedInName+'&linkedPass='+linkedInPass,
    type: "GET",
    dataType: "JSON",
    success: function(feeds) {
    var content = [];
    feed = feeds.contentFB;
    feedLI = feeds.contentLI;
    drawTableFBFeed(feed);
    drawTableLIFeed(feedLI);
    }
});
}

function drawTableFBFeed(feed) {
    $("#fbFeed tbody").remove();
    $("#fbFeed").append("<tbody id=\"fbFeedBody\"></tbody>");
    for (var i = 0; i < feed.length; i++) {
        drawRowFB(feed[i]);
    };
}

function drawRowFB(rowDataFB) {
    var rowFBFeed = $("<tr />");
    $("#fbFeed").append(rowFBFeed);
    rowFBFeed.append($("<td>" + rowDataFB.story +"<br>" + rowDataFB.message + "</td>"));
}

function drawTableLIFeed(feedLI) {
    $("#liFeed tbody").remove();
    $("#liFeed").append("<tbody id=\"liFeedBody\"></tbody>");
    for (var i = 0; i < feedLI.length; i++) {
        feedLIInner = feedLI[i];
        for (var j = 0; j <feedLIInner.length; j++) {
        drawRowLI(feedLIInner[j]);}
    };
}

function drawRowLI(rowDataLI) {
    var rowLIFeed = $("<tr />");
    $("#liFeed").append(rowLIFeed);
    rowLIFeed.append($("<td>" + "feed name: " + rowDataLI.feedName + "<br>"
        + "header: " + rowDataLI.header + "<br>"
        + "meta data: " + rowDataLI.meta + "<br>"
        + "headline: " + rowDataLI.headline + "<br>"
        + "author: " + rowDataLI.author + "<br>"
        + "text: " + rowDataLI.textEntity + "<br>"
        + "rollup: " + rowDataLI.rollup + "<br>"
        + "</td>"));
}