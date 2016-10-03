# Prevailer
Prevailer is a simple android library that helps in preserving object instances across orientation change in android and is JAVA 8 and MVP ready.

## How to use
* Add the dependency
```gradle
	dependencies {
	  compile 'com.mukesh:prevailer:1.0.0'
	}
```

* In your Activity / Fragment onCreate call
```java
Prevailer.init(
		this, // activity instance
		23, // unique id of loader used
		new PrevailerFactory<ObjectToBePreserved>() { // factory for the instance that should be preserved
		    @Override
		    public ObjectToBePreserved create() {
		        return new MyTypeToBePreserved();
		    }
		},
		new Prevailer.OnInstanceReloadedAction<ObjectToBePreserved>() {
		    @Override
		    public void performAction(MyTypeToBePreserved instance) {
          // do what needs to be done when reloaded
		    }
		},
		new Prevailer.OnInstanceDestroyedAction() {
		    @Override
		    public void performAction() {
          // do what needs to be done when destroyed
		    }
		}
);
```

* Use with JAVA 8
```java
Prevailer.init(this, 23,
                (PrevailerFactory<MyTypeToBePreserved>) () -> new ObjectToBePreserved(),
                (Prevailer.OnInstanceReloadedAction<ObjectToBePreserved>) instance -> {
                    // do what needs to be done when reloaded
                },
                (Prevailer.OnInstanceDestroyedAction) () -> {
                    // do what needs to be done when destroyed
                }
);
```

## Why do we need Prevailer
The need for prevailer has been around from a very long time the developers in the android community have been fighting this issue from a really long time.
Prevailer works with MVP approach making development easy in case where the presenters had to be maintained or kept alive when the orientation changed.

## How does it work
Prevailer uses Android Loader API under the hood. On Android platform, Loaders framework provides API for asynchronous data loading in Activity or Fragment.
However, Loaders has special property of preserving instance of the handled object when it's reloaded.
Prevailer benefits from that to provide simple way of caching (preserving) instances of objects that mustn't be destroyed during orientation changes.
Preserved instances are destroyed when the activity holding them is  abandoned and no longer used.