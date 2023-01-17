console.log("Reply Module.......");

/**
 * @author Devesg
 * @param reply
 * @example
 * replyService.get(reply{bno : bnoValue, id : "admin", contents : "test" },function (result){ alert("result: " + result) })
 */
var replyService=(function(){
	
	function add(reply, callback, error){
		
		console.log("add reply..");
		$.ajax({
			type : 'post',
			url : '/replies/write',
			data : JSON.stringify(reply),
			contentType : "application/json",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
			
		})
	}
	
    function getList(param, callback, error) {
        var bno = param.bno;
        var page = param.page || 1;

        $.getJSON("/replies/pages/" + bno + "/" + page + ".json",
            function (data) {
                if (callback) {
                    callback(data);
                }
            }).fail(function (xhr, status, err) {
                if (error) {
                    error();
                }
            });
    }

    function remove(rno, callback, error) {
        $.ajax({
            type: 'delete',
            url: "/replies/" + rno,
            success: function (deleteResult, status, xhr) {
                if (callback) {
                    callback(deleteResult)
                }
            },
            error: function (xhr, status, er) {
                console.log('rno :>> ', rno);
                if (error) {
                    console.log('error :>> ', error);
                    error(er)
                }
            }
        });
    }

    function update(reply, callback, error) {
        console.log('reply.rno :>> ', reply.rno);

        $.ajax({
            type: "put",
            url: "/replies/" + reply.rno,
            data: JSON.stringify(reply),
            contentType: 'application/json; charset=utf-8',
            success: function (result, status, xhr) {
                if (callback) {
                    callback(result)
                }
            }, error: function (xhr, status, er) {
                if (error) {
                    error(er)
                }
            }
        });
    }

    function get(rno, callback, error) {
        $.get("/replies/" + rno + ".json", function (result) {

            if (callback) {
                callback(result)
            }

        }).fail(function (xhr, status, err) {
            if (error) {
                error();
            }
        });
    }

    return {
        add: add,
        getList: getList,
        get: get,
        remove: remove,
        update: update
    };

})();

// replyService.update({
//     rno:52,
//     bno:bnoValue,
//     contents:"modified Reply..."
// },function(result)
// {
//     alert("수정 완료...");
// })

// replyService.add({
//     bno : bnoValue, id : "admin", contents : "dsad test" },function (result){ alert("result: " + result);})

// replyService.remove(55,function(count) {
//     console.log(count);
//     if (count === "success") { alert("REMOVED")}},function(err) { alert("ERROR..");})
