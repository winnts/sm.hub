function getLIFeeds(linkedInName, linkedInPass) {
$.ajax({
    url: '/feeds?linkedName='+linkedInName+'&linkedPass='+linkedInPass,
    type: "GET",
    dataType: "JSON",
    success: function(feeds) {
    var content = [];
    feedLI = feeds.contentLI;
    drawTableLIFeed(feedLI);
    }
});
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