
var getAllQuestionsURI = "restapi/questions";
var getAnswerURI = "restapi/answer";

findAllQuestions();


function renderAnswer(data){
	
	$.get("answer.html", function(dataHtml){
		var divcontent =dataHtml;
	    $("#main_content").html(divcontent);
	});
}


function getAnswer(questionId) {
	console.log('getAnswer');
	$.ajax({
		type : 'GET',
		url : getAnswerURI,
		data: { 
			questionId: questionId
		  },
		dataType : "json", 
		success : renderAnswer
	});
}

function findAllQuestions() {
	console.log('findAllQuestions');
	$.ajax({
		type : 'GET',
		url : getAllQuestionsURI,
		dataType : "json", 
		success : renderQuestionList
	});
}

function renderQuestionList(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [ data ]);
	$('#main_questions_list li').remove();
	$.each(list, function(index, val) {
		
		var result='<li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem" class="question-item" >'
			+'<div itemprop="item" itemscope="" itemtype="http://schema.org/Question">'
			+'<div class="col-md-8 col-xs-8 q-left-content"><div class="q-ltop-content"><h2 itemprop="name">'
			+'<a itemprop="url" href="#" onclick="renderAnswer('+val.id+');" class="question-title">'+val.title+'</a></h2></div>'
			+'<div class="q-lbtm-content"><div itemprop="text" class="question-excerpt">'
			+'<p>'+val.content+'</p></div><div class="question-cat"><ul class="question-tags"><li><a class="q-tag" href="#">'+val.category+' </a></li></ul>'
			+'<div class="clearfix"></div><a itemprop="author" itemscope="" itemtype="http://schema.org/Person" href="#"><span class="author-avatar"> <img itemprop="image" src="./1282.jpg" class="avatar" alt="">'
			+'</span> <span itemprop="name" class="author-name">'+val.userName+'</span></a> <span title="46" class="user-badge" style="background-color: #04aad4;">Train</span> '
			+'<span itemprop="dateCreated"  class="question-time"> Asked on '+val.creationDate+' </span> </div></div></div>'
			+'<div class="col-md-4 col-xs-4 q-right-content"><ul class="question-statistic"><li><span class="question-views"> '+val.views+' </span> views</li>'
			+'<li class="active"><span itemprop="answerCount" class="question-answers"> '+val.answerCount+' </span> answers</li>'
			+'<li><span itemprop="upvoteCount" class="question-votes">2 </span> votes</li></ul><div class="pumping"></div></div><div class="clearfix"></div>'
		    +'</div></li>';
		
		$('#main_questions_list').append(result);
	});
}
