$(document).ready(function(){
				//$(".list").hide();//二级默认折叠
				$(".box .title_1").toggle(function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_1 span").attr("class","menu2")
                    .siblings(".menu2")
                    .attr("class", "menu1");
				},function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_1 span").attr("class","menu1")
                    .siblings(".menu1")
                    .attr("class", "menu2");
				})
				$(".box .title_2").toggle(function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_2 span").attr("class","menu2")
                    .siblings(".menu2")
                    .attr("class", "menu1");
				},function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_2 span").attr("class","menu1")
                    .siblings(".menu1")
                    .attr("class", "menu2");
				})
				$(".box .title_3").toggle(function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_3 span").attr("class","menu2")
                    .siblings(".menu2")
                    .attr("class", "menu1");
				},function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_3 span").attr("class","menu1")
                    .siblings(".menu1")
                    .attr("class", "menu2");
				})
				$(".box .title_4").toggle(function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_4 span").attr("class","menu2")
                    .siblings(".menu2")
                    .attr("class", "menu1");
				},function(){
					$(this).next(".list").slideToggle("slow");
					jQuery(".box .title_4 span").attr("class","menu1")
                    .siblings(".menu1")
                    .attr("class", "menu2");
				})
				
				$("#red").treeview({
					persist: "location",
					collapsed: true,
					unique: true
				});
			});