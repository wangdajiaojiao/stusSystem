$(function() {
		$("#res").delegate("p", "click", function() {
			var id = $(this).text();
			$("#id").val(id);
			$("#res").hide();
		});
		$(".input").on('input', function(e) {
			var id = $.trim($("#id").val());
			var classname = $.trim($("#classname").val());
			var clazz = $.trim($("#class").val());
			if (id == "" && classname == "" && clazz == "") {
				$("#res").hide();
			}
			if(id==""){
			function tt(dd) {
		}
		$.get(
			"SearchServlet?type=count",
			function(count) {
				var GG = {
					"kk" : function(mm) {
						$.get(
							"SearchServlet?type=currentPage&cp=" + mm,
							function(data) {
								var stus = eval("(" + data + ")");
								var str = "";
								for (var i = 0; i < stus.length; i++) {
									str += "<tr><td>" + stus[i].id + "</td>"
									str = str + "<td>" + stus[i].studentNo + "</td>"
									str = str + "<td>" + stus[i].studentName + "</td>"
									str = str + "<td>" + stus[i].studentClass + "</td>"
									str = str + "<td>" + "<a href='javascript:a(" + stus[i].id + ")'>" + "删除" + "</a>" + "</td></tr>"
								}
								$("#tbody").html(str);
							}
						);
					}
				}
				$("#page").initPage(count * 5, 1, GG.kk);
			});
			}
			if (id != "") {
				$("#res").show();
				$.ajax({
					type : "get",
					url : "SearchServlet?type=search&key=" + id,
					success : function(msg) {
						if (msg == "无结果") {
							var str = msg;
							$("#res").html("<p style='font-size:12px'>" + str + "</p>");
						} else {
							var obj = eval("(" + msg + ")");
							var str = "";
							for (var i = 0; i < obj.length; i++) {
								str = str + "<p>" + obj[i].id + "</p>";
							}
							$("#res").html("<p style='font-size:12px'>" + str + "</p>");
						}
					}
				});
			}
		});
		$("#btn").click(function() {
			$("#res").hide();
			var id = $.trim($("#id").val());
			;
			var reg = "^[0-9]*$";
			var re = new RegExp(reg);
			if (!re.test(id)) {
				alert("请输入数字");
			}
			var classname = $.trim($("#classname").val());
			var clazz = $.trim($("#class").val());
			if (id == "" && classname == "" && clazz == "") {
				alert("请至少输入一个筛选条件");
			} else {
				function tt(dd) {
				}
				$.get(
					"SearchServlet?type=countById&cid=" + id,
					function(countById) {
						var GG = {
							"kk" : function(mm) {
								$.ajax({
									type : "post",
									url : "SearchServlet",
									data : {
										"type" : "find",
										"id" : id,
										"classname" : classname,
										"class" : clazz,
										"mm" : mm
									},
									success : function(msg) {
										if ("无结果" == msg) {
											alert(msg);
											$("#id").val("");
											$("#classname").val("");
											$("#class").val("");
										}
										var stus = eval("(" + msg + ")");
										$("#tbody").empty;
										var str = "";
										for (var i = 0; i < stus.length; i++) {
											str = str + "<tr><td>" + stus[i].id + "</td>"
											str = str + "<td>" + stus[i].studentNo + "</td>"
											str = str + "<td>" + stus[i].studentName + "</td>"
											str = str + "<td>" + stus[i].studentClass + "</td>"
											str = str + "<td>" + "<a href='javascript:a(" + stus[i].id + ")'>" + "删除" + "</a>" + "</td></tr>"
										}
										$("#tbody").html(str);
									}
								});
							}
						}
						$("#page").initPage(countById * 5, 1, GG.kk);
					}
				);

			}
		});
		 function tt(dd) {
		}
		$.get(
			"SearchServlet?type=count",
			function(count) {
				var GG = {
					"kk" : function(mm) {
						$.get(
							"SearchServlet?type=currentPage&cp=" + mm,
							function(data) {
								var stus = eval("(" + data + ")");
								var str = "";
								for (var i = 0; i < stus.length; i++) {
									str += "<tr><td>" + stus[i].id + "</td>"
									str = str + "<td>" + stus[i].studentNo + "</td>"
									str = str + "<td>" + stus[i].studentName + "</td>"
									str = str + "<td>" + stus[i].studentClass + "</td>"
									str = str + "<td>" + "<a href='javascript:a(" + stus[i].id + ")'>" + "删除" + "</a>" + "</td></tr>"
								}
								$("#tbody").html(str);
							}
						);
					}
				}
				$("#page").initPage(count * 5, 1, GG.kk);
			}); 
	});
