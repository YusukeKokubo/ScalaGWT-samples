package com.appspot.b4sg.client

import com.google.gwt.user.client.rpc.AsyncCallback

trait GreetingServiceAsync {
  def hoge(name: String, callback: AsyncCallback[String]) : Unit
  def count(callback: AsyncCallback[Int]) : Unit
  def getCount(callback: AsyncCallback[Int]) : Unit
}