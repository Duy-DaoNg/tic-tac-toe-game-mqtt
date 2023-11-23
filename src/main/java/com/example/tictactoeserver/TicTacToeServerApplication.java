package com.example.tictactoeserver;

import com.example.tictactoeserver.config.MqttConfig;

public class TicTacToeServerApplication {
	public static void main(String[] args) throws Exception {
		// create and configure MQTT client
		// final Mqtt5BlockingClient client = MqttConfig.configureMqttClient();
		MqttConfig client = new MqttConfig();

	}
}
