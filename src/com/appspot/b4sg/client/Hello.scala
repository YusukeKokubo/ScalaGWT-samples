package com.appspot.b4sg.client;

import com.google.gwt.core.client.EntryPoint
import com.google.gwt.event.dom.client.ClickEvent
import com.google.gwt.event.dom.client.ClickHandler
import com.google.gwt.user.client.ui.Button
import com.google.gwt.user.client.Window
import com.google.gwt.user.client.ui.RootPanel
import com.google.gwt.user.client.ui.Grid
import com.google.gwt.core.client.GWT
import com.google.gwt.user.client.rpc.AsyncCallback
import com.google.gwt.user.client.ui.TextBox
import com.google.gwt.user.client.ui.Label

class Hello extends EntryPoint {

  val service = GWT.create(classOf[GreetingService]).asInstanceOf[GreetingServiceAsync]
  
  val countLabel = new Label

  def onModuleLoad() {
    val textBox = new TextBox
    val b = new Button("send", (_: ClickEvent) => service.hoge(textBox.getValue(), MyAsyncCallback()));
    RootPanel.get("button").add(b);
    RootPanel.get("text").add(textBox);
    
    service.getCount(GetCountCallback())
  }

  implicit def clickHandler(f: ClickEvent => Unit): ClickHandler = new ClickHandler {
    def onClick(event: ClickEvent) = f(event)
  }

  case class MyAsyncCallback() extends AsyncCallback[String] {
    def onSuccess(result: String) = Window.alert(result)
    def onFailure(caught: Throwable) = Window.alert("")
  }
  
  case class CountCallback() extends AsyncCallback[Int] {
    def onSuccess(result: Int) = countLabel.setText(result.toString())
    def onFailure(caught: Throwable) = Window.alert("")
  }
  
  case class GetCountCallback() extends AsyncCallback[Int] {
    def onSuccess(result: Int) = {
      countLabel.setText(result.toString())
      RootPanel.get("countLabel").add(countLabel)
      val countButton = new Button("count", (_: ClickEvent) => service.count(CountCallback()))
      RootPanel.get("countButton").add(countButton)
    }
    def onFailure(caught: Throwable) = Window.alert("")
  }
}
