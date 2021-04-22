package com.sumbab.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumbab.project.model.NoticeService;

@Controller
public class NoticeController {

	private NoticeService noticeService;

	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@RequestMapping("/mypage/noticePage")
	public String firstPage(Model model, HttpSession session/*,@PathVariable String id*/) {
		String id="admin1";
		session.setAttribute("classify", noticeService.classify(id));
		model.addAttribute("noticeList", noticeService.bringNotice(id));
		return "mypage/noticePage";
	}
	
	@RequestMapping("/mypage/noticeDetail/{noticeNum}")
	public String noticeDetail(Model model, @PathVariable int noticeNum) {
		model.addAttribute("noticeVo", noticeService.noticeDetail(noticeNum));
		return "mypage/noticeDetail";
	}
}
