module.exports = Object.create(null);

/** Some(v) */
class Some {
   constructor(data) {
      // the comment below is to warn people against accessing the _data
      // property directly since we don't have private properties yet
      // Currently in stage 3. See below:
      // https://github.com/tc39/proposal-class-fields
      /**
       * Uh, doesn't using this defeat the point of an Option?
       */
      this._data = data;
      this.is_some = true;
      this.is_none = false;
   };
   expect() { return this._data };
   map(f) { return f(this._data) };
   map_or(_, f) { return new Some(f(this._data)) };
   and_then(f) { return f(this._data) };
   or() { return this };
   or_else() { return this };
   match(obj) { return obj.Some(this._data) };
   /** @see Some */
   unwrap() { return this._data };
   unwrap_or() { return this._data };
   unwrap_or_else() { return this._data };
}

module.exports.Some = Some;

const None = {
   is_none: true,
   is_some: false,
   expect(msg) { throw new Error(msg) },
   unwrap() { throw new Error("Called unwrap on None!") },
   unwrap_or(v) { return v },
   unwrap_or_else(f) { f() },
   map() { return None },
   map_or(d) { return d },
   and_then() { return None },
   or(opt_b) { return opt_b },
   or_else(f) { return f() },
   match(obj) { return obj.None() },
}

module.exports.None = None;
