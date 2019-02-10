package me.zohar.lottery.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.common.param.PageParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.game.param.GamePlayParam;
import me.zohar.lottery.game.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/findAllGame")
	@ResponseBody
	public Result findAllGame(PageParam param) {
		return Result.success().setData(gameService.findAllGame());
	}

	@GetMapping("/findGamePlayByGameCode")
	@ResponseBody
	public Result findGamePlayByGameCode(String gameCode) {
		return Result.success().setData(gameService.findGamePlayByGameCode(gameCode));
	}

	@GetMapping("/findGamePlayDetailsById")
	@ResponseBody
	public Result findGamePlayDetailsById(String id) {
		return Result.success().setData(gameService.findGamePlayDetailsById(id));
	}

	@GetMapping("/updateGamePlayState")
	@ResponseBody
	public Result updateGamePlayState(String id, String state) {
		gameService.updateGamePlayState(id, state);
		return Result.success();
	}

	@PostMapping("/addOrUpdateGamePlay")
	@ResponseBody
	public Result addOrUpdateGamePlay(@RequestBody GamePlayParam gamePlayParam) {
		gameService.addOrUpdateGamePlay(gamePlayParam);
		return Result.success();
	}
	
	@GetMapping("/delGamePlayById")
	@ResponseBody
	public Result delGamePlayById(String id) {
		gameService.delGamePlayById(id);
		return Result.success();
	}

}